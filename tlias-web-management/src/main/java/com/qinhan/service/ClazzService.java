package com.qinhan.service;

import com.qinhan.pojo.Clazz;
import com.qinhan.pojo.ClazzQueryParam;
import com.qinhan.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    void add(Clazz clazz);

    List<Clazz> findAll();

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void removeById(Integer id);


    Clazz findById(Integer id);

}
