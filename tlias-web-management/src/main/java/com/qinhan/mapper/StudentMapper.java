package com.qinhan.mapper;

import com.qinhan.pojo.Student;
import com.qinhan.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 分页条件查询
     */
    List<Student> selectPage(StudentQueryParam studentQueryParam);

    /**
     * 批量删除学生信息
     */
    void deleteBatch(List<Integer> ids);

    /**
     * 添加学生信息
     */
    @Insert("insert into student(name,no,gender,phone,degree,clazz_id,id_card,is_college,address,graduation_date,create_time,update_time) values \n" +
            "                    (#{name},#{no},#{gender},#{phone},#{degree},#{clazzId},#{idCard},#{isCollege},#{address},#{graduationDate},#{createTime},#{updateTime})")
    void insertStudent(Student student);

    @Select("select id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time from student where id = #{id}")
    Student selectStudentById(Integer id);

    /**
     * 修改学生信息
     */
    void update(Student student);
}
