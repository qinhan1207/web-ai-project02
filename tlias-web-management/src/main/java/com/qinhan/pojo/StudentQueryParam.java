package com.qinhan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生分页条件查询参数类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    private String name;
    private Integer degree;
    private Integer clazzId;
    private Integer page=1;
    private Integer pageSize=10;
}
