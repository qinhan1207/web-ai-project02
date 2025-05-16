package com.qinhan.service;


import com.qinhan.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有的部门数据
     * @return
     */
    List<Dept> findAll();
}
