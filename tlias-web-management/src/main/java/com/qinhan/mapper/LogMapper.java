package com.qinhan.mapper;

import com.qinhan.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    /**
     * 分页查询所有日志
     */
    @Select("select o.*,e.name operateEmpName from operate_log o left join emp e on o.operate_emp_id = e.id")
    List<OperateLog> list();
}
