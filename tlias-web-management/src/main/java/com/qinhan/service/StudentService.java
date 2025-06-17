package com.qinhan.service;

import com.qinhan.pojo.PageResult;
import com.qinhan.pojo.Student;
import com.qinhan.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    /**
     * 分页条件查询
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 批量删除学生信息
     */
    void removeBatch(List<Integer> ids);

    /**
     * 添加学生信息
     */
    void addStudent(Student student);

    /**
     * 根据id查询学生信息
     */
    Student findStudentById(Integer id);

    /**
     * 修改学生信息
     */
    void modify(Student student);
}
