package com.qinhan.mapper;

import com.qinhan.pojo.Clazz;
import com.qinhan.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /**
     * 新增一个班级
     */
    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) VALUES (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime})")
    void add(Clazz clazz);

    /**
     * 查询所有班级
     */
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
    List<Clazz> findAll();


    /**
     * 分页条件查询
     */
    List<Clazz> selectPage(ClazzQueryParam clazzQueryParam);

    /**
     * 根据id删除一个班级
     */
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    /**
     * 根据id查询clazz基本信息：查询回显
     */
    @Select("select * from clazz where id = #{id}")
    Clazz selectById(Integer id);
}
