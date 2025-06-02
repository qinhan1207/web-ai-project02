package com.qinhan.controller;

import com.qinhan.pojo.Clazz;
import com.qinhan.pojo.Result;
import com.qinhan.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 添加班级功能
     * @param clazz
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加一个班级");
        clazzService.add(clazz);
        return Result.success();
    }

    /**
     * 查询所有班级信息
     * @return
     */
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }
}
