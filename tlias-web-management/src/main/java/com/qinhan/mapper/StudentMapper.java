package com.qinhan.mapper;

import com.qinhan.pojo.Student;
import com.qinhan.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 分页条件查询
     */
    List<Student> selectPage(StudentQueryParam studentQueryParam);

}
