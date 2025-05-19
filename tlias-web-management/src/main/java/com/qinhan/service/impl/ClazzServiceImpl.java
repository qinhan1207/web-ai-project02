package com.qinhan.service.impl;

import com.qinhan.mapper.ClazzMapper;
import com.qinhan.pojo.Clazz;
import com.qinhan.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
