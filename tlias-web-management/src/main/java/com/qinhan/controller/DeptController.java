package com.qinhan.controller;

import com.qinhan.pojo.Dept;
import com.qinhan.pojo.Result;
import com.qinhan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET) // method:指定请求方式
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}
