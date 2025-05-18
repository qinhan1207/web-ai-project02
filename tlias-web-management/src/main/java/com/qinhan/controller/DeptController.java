package com.qinhan.controller;

import com.qinhan.pojo.Dept;
import com.qinhan.pojo.Result;
import com.qinhan.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 删除部门 - 方式一：基于HttpServletRequest 方式来获取参数
     */
    //@DeleteMapping("/depts")
    //public Result delete(HttpServletRequest request){
    //    String idStr = request.getParameter("id");
    //    Integer id = Integer.valueOf(idStr);
    //    System.out.println("根据id删除部门数据: id=" + id);
    //    return Result.success();
    //}

    /**
     * 删除部门 - 方式二：@RequestParam
     * 注意事项：一旦声明了@RequestParam，该参数在请求时必须传递，如果不传递将会报错。（默认required为true）
     */
    //@DeleteMapping("/depts")
    //public Result delete(@RequestParam(value = "id",required = false) Integer deptId){
    //    System.out.println("根据id删除部门数据: id=" + deptId);
    //    return Result.success();
    //}

    /**
     * 删除部门 - 方式三：省略@RequestParam（当前端传递的请求参数名与服务器方法形参名一致时）[推荐]
     */
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        deptService.deleteById(id);
        System.out.println("根据id删除部门数据: id=" + id);
        return Result.success();
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping("depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("添加部门"+dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     */
    //@GetMapping("/depts/{id}")
    //public Result getInfo(@PathVariable("id") Integer deptId){
    //    System.out.println("根据id查询部门:"+deptId);
    //    return Result.success();
    //}

    /**
     * 根据id查询部门
     */
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("根据id查询部门:"+id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门的数据
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门"+dept);
        deptService.update(dept);
        return Result.success();
    }
}
