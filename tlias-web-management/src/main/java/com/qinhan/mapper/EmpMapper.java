package com.qinhan.mapper;

import com.qinhan.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 操作员工信息的mapper接口
 */
@Mapper
public interface EmpMapper {

    // -------------------------------------------------原始分页查询的方式------------------------------------
    /**
     * 查询总记录数
     * @return
     */
    //@Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    //public Long count();

    ///**
    // * 分页查询
    // * @param start
    // * @param pageSize
    // * @return
    // */
    //@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
    //        "order by e.update_time desc limit #{start},#{pageSize}")
    //public List<Emp> list(Integer start, Integer pageSize);

    //@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

}
