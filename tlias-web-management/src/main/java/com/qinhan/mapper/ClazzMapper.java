package com.qinhan.mapper;

import com.qinhan.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClazzMapper {
    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) VALUES (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime})")
    void add(Clazz clazz);
}
