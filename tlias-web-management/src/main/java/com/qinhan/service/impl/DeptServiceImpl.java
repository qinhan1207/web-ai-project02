package com.qinhan.service.impl;

import com.qinhan.mapper.DeptMapper;
import com.qinhan.pojo.Dept;
import com.qinhan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        // 1.补全基本属性 - createTime,updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 2.调用mapper接口方法来插入数据
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        // 1.补全基础属性 - updateTime
        dept.setUpdateTime(LocalDateTime.now());
        // 2.调用Mapper接口方法更新部门
        deptMapper.update(dept);
    }
}
