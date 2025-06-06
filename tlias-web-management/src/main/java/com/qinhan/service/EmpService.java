package com.qinhan.service;


import com.qinhan.pojo.Emp;
import com.qinhan.pojo.EmpQueryParam;
import com.qinhan.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
    ///**
    // * 分页查询的方法
    // *
    // * @param page     页码
    // * @param pageSize 每页展示记录数
    // * @return
    // */
    //PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     */
    void save(Emp emp);
}
