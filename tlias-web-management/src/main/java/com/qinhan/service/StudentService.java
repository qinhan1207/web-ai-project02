package com.qinhan.service;

import com.qinhan.pojo.PageResult;
import com.qinhan.pojo.Student;
import com.qinhan.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);
}
