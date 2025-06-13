package com.qinhan.controller;

import com.qinhan.pojo.Clazz;
import com.qinhan.pojo.ClazzQueryParam;
import com.qinhan.pojo.PageResult;
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
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加一个班级");
        clazzService.add(clazz);
        return Result.success();
    }

    /**
     * 查询所有班级信息
     */
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }

    /**
     * 分页条件查询所有班级
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询:{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 根据id删除班级信息
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        clazzService.removeById(id);
        return Result.success();
    }


    /**
     * 根据id查询：查询回显
     */
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

    /**
     * 根据id修改员工信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.modify(clazz);
        return Result.success();
    }

}
