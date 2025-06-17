package com.qinhan.service;

import com.qinhan.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计员工职位人数
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计学生学历信息
     */
    List<Map<String, Object>> getStudentDegreeData();
}
