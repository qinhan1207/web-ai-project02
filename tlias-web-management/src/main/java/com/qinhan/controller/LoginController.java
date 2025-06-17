package com.qinhan.controller;

import com.qinhan.pojo.Emp;
import com.qinhan.pojo.LoginInfo;
import com.qinhan.pojo.Result;
import com.qinhan.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录Controller
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}",emp);
        LoginInfo info = empService.login(emp);
        if (info != null){
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
