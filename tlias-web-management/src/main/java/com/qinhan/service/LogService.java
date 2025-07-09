package com.qinhan.service;

import com.qinhan.pojo.OperateLog;
import com.qinhan.pojo.PageResult;

public interface LogService {
    /**
     * 分页查询所有日志
     */
    PageResult<OperateLog> page(Integer page,Integer pageSize);
}
