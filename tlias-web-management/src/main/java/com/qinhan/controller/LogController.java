package com.qinhan.controller;

import com.qinhan.pojo.Result;
import com.qinhan.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询所有日志
     */
    @GetMapping("/page")
    public Result page(Integer page,Integer pageSize){
        return Result.success(logService.page(page,pageSize));
    }
}
