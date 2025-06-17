package com.qinhan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qinhan.mapper.StudentMapper;
import com.qinhan.pojo.PageResult;
import com.qinhan.pojo.Student;
import com.qinhan.pojo.StudentQueryParam;
import com.qinhan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        // 1.使用pageHelper进开始分页
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        // 2.对查询的数据进行封装
        List<Student> students = studentMapper.selectPage(studentQueryParam);
        Page<Student> p = (Page<Student>) students;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void removeBatch(List<Integer> ids) {
        studentMapper.deleteBatch(ids);
    }

    @Override
    public void addStudent(Student student) {
        // 1.为student补全属性
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        // 2.调用mapper接口
        studentMapper.insertStudent(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentMapper.selectStudentById(id);
    }
}
