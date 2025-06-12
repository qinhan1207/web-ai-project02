package com.qinhan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qinhan.mapper.EmpExprMapper;
import com.qinhan.mapper.EmpMapper;
import com.qinhan.pojo.*;
import com.qinhan.service.EmpLogService;
import com.qinhan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;

    ///**
    // * 原始的分页查询
    // * @param page 页码
    // * @param pageSize 每页展示记录数
    // * @return
    // */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 调用mapper接口查询总记录数
        Long total = empMapper.count();
        // 调用mapper接口查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        // 封装结果
        return new PageResult<Emp>(total, rows);
    }*/

    ///**
    // * PageHelper分页查询
    // *
    // * @param page     页码
    // * @param pageSize 每页展示记录数
    // * @return 注意事项：
    // * 1.定义的sql语句结尾不能加分分号
    // * 2.PageHelper仅仅对紧跟在其后的第一个查询语句进行分页处理
    // */
    //@Override
    //public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
    //    // 1.设置分页参数(PageHelper)
    //    PageHelper.startPage(page, pageSize);
    //    // 2.执行查询
    //    List<Emp> empList = empMapper.list(name, gender, begin, end);
    //    // 3.解析查询结果，封装参数
    //    Page<Emp> p = (Page<Emp>) empList;
    //
    //    return new PageResult<Emp>(p.getTotal(), p.getResult());
    //}

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 1.设置分页参数(PageHelper)
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 2.执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        // 3.解析查询结果，封装参数
        Page<Emp> p = (Page<Emp>) empList;

        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})  // 事务管理的注解 - 默认出现运行时异常RuntimeException才会回滚
    @Override
    public void save(Emp emp) throws Exception {
        try {
            // 1.保存员工的基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            // 2.保存员工的工作经历信息
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                // 遍历集合，为empId赋值
                exprList.forEach(expr -> {
                    expr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 记录操作日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工"+emp);
            empLogService.insertLog(empLog);
        }


    }

    @Override
    public List<Emp> getAllEmp() {
        return empMapper.selectAll();
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        // 1.批量删除员工的基本信息
        empMapper.deleteByIds(ids);
        // 2.批量删除员工的工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }
}
