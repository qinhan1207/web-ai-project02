package com.qinhan.controller;

import com.qinhan.pojo.Emp;
import com.qinhan.pojo.EmpQueryParam;
import com.qinhan.pojo.PageResult;
import com.qinhan.pojo.Result;
import com.qinhan.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //@GetMapping
    //public Result page(@RequestParam(defaultValue = "1") Integer page,
    //                   @RequestParam(defaultValue = "10") Integer pageSize,
    //                   String name, Integer gender,
    //                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
    //                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
    //    log.info("分页查询:{},{},{},{},{},{}", page, pageSize,name,gender,begin,end);
    //    PageResult<Emp> pageResult = empService.page(page, pageSize,name,gender,begin,end);
    //    return Result.success(pageResult);
    //}

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询:{}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增操作
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) throws Exception{
        log.info("新增员工:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        List<Emp> empList = empService.getAllEmp();
        return Result.success(empList);
    }
}
