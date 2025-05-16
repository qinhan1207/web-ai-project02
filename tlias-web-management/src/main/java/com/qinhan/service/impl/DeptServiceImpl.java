package com.qinhan.service.impl;

import com.qinhan.mapper.DeptMapper;
import com.qinhan.pojo.Dept;
import com.qinhan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
