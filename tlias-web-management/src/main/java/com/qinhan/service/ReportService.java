package com.qinhan.service;

import com.qinhan.pojo.JobOption;

public interface ReportService {
    /**
     * 统计员工职位人数
     */
    JobOption getEmpJobData();
}
