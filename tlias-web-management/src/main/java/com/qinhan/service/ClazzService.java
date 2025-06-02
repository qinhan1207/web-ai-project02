package com.qinhan.service;

import com.qinhan.pojo.Clazz;

import java.util.List;

public interface ClazzService {
    void add(Clazz clazz);

    List<Clazz> findAll();
}
