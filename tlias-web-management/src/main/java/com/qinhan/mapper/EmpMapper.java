package com.qinhan.mapper;

import com.qinhan.pojo.Emp;
import com.qinhan.pojo.EmpQueryParam;
import com.qinhan.pojo.JobOption;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 操作员工信息的mapper接口
 */
@Mapper
public interface EmpMapper {

    // -------------------------------------------------原始分页查询的方式------------------------------------
    ///**
    // * 查询总记录数
    // */
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
    //public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 条件查询员工信息
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工基本信息
     */
    @Options(useGeneratedKeys = true,keyProperty = "id") // 获取到生成的主键 -- 主键返回
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select id, username, password, name, gender,image, job, salary,  entry_date, dept_id, create_time, update_time from emp")
    List<Emp> selectAll();

    /**
     * 根据ID批量删除员工的基本信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询员工信息以及工作经历信息
     */
    Emp getById(Integer id);

    /**
     * 根据id更新员工的基本信息
     */
    void updateById(Emp emp);

    /**
     * 统计员工职位人数
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();
}
