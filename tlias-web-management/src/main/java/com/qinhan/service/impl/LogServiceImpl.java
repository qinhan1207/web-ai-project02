package com.qinhan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qinhan.mapper.LogMapper;
import com.qinhan.pojo.OperateLog;
import com.qinhan.pojo.PageResult;
import com.qinhan.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<OperateLog> page(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OperateLog> logList = logMapper.list();
        Page<OperateLog> p = (Page<OperateLog>) logList;
        return new PageResult<OperateLog>(p.getTotal(),p.getResult());
    }
}
