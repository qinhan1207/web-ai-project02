package com.qinhan.service.impl;

import com.qinhan.mapper.EmpMapper;
import com.qinhan.mapper.StudentMapper;
import com.qinhan.pojo.ClazzOption;
import com.qinhan.pojo.JobOption;
import com.qinhan.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        // 1.调用mapper接口，获取统计数据
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        // 2.组装结果并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public ClazzOption getStudentCountData() {
        // 1.获取到每个班级以及每个班级学生人数的集合
        List<Map<String,Object>> list = studentMapper.countStudentCountData();
        // 2.处理数据
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new ClazzOption(clazzList,dataList);
    }
}
