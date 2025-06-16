package com.qinhan.controller;

import com.qinhan.pojo.PageResult;
import com.qinhan.pojo.Result;
import com.qinhan.pojo.Student;
import com.qinhan.pojo.StudentQueryParam;
import com.qinhan.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询:{}",studentQueryParam);
        PageResult<Student> students = studentService.page(studentQueryParam);
        return Result.success(students);
    }

    /**
     * 批量删除
     */
    @DeleteMapping("{ids}")
    public Result removeBatch(@PathVariable List<Integer> ids){
        studentService.removeBatch(ids);
        return Result.success();
    }

    /**
     * 添加学生信息
     */
    @PostMapping
    public Result save(@RequestBody Student student){
        studentService.addStudent(student);
        return Result.success();
    }
}
