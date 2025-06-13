package com.qinhan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qinhan.mapper.ClazzMapper;
import com.qinhan.pojo.Clazz;
import com.qinhan.pojo.ClazzQueryParam;
import com.qinhan.pojo.PageResult;
import com.qinhan.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public void add(Clazz clazz) {
        // 1.补全clazz中的全部属性
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        // 2.调用mapper接口
        clazzMapper.add(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        // 1.设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        // 2.执行查询
        List<Clazz> clazzList = clazzMapper.selectPage(clazzQueryParam);
        // 3.遍历查询结果
        //      3.1如果当前时间<开课时间：未开课
        //      3.2如果当前时间>结课时间：已结课
        //      3.3否则：在读
        clazzList.forEach(clazz -> {
            if (LocalDate.now().isBefore(clazz.getBeginDate())){
                clazz.setStatus("未开课");
            } else if (LocalDate.now().isAfter(clazz.getEndDate())){
                clazz.setStatus("已结课");
            } else {
                clazz.setStatus("在读");
            }
        });

        // 4.解析查询结果，封装参数
        Page<Clazz> p = (Page<Clazz>) clazzList;

        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

    @Override
    public void removeById(Integer id) {
        clazzMapper.deleteById(id);
    }
}
