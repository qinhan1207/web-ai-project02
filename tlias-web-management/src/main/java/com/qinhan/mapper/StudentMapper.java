package com.qinhan.mapper;

import com.qinhan.pojo.Student;
import com.qinhan.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> selectPage(StudentQueryParam studentQueryParam);

}
