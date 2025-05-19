package com.qinhan.controller;

import com.qinhan.pojo.Clazz;
import com.qinhan.pojo.Result;
import com.qinhan.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加一个班级");
        clazzService.add(clazz);
        return Result.success();
    }
}
