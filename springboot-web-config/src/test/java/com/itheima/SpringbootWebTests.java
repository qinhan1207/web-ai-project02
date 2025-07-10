package com.itheima;

import cn.hutool.core.io.FileUtil;
import com.itheima.controller.DeptController;
import com.itheima.utils.AliyunOSSOperator;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.File;

@SpringBootTest
class SpringbootWebTests {

    @Autowired
    private ApplicationContext applicationContext;  // IOC容器

    private AliyunOSSOperator aliyunOSSOperator;

    @Test
    public void testScope(){
        for (int i = 0; i < 1000; i++) {
            Object deptController = applicationContext.getBean("deptController");
            System.out.println(deptController);
        }
    }

    @Test
    public void upload() throws Exception {
        File file = new File("\u202AD:\\ChromeDownloads\\5490cfbd39dc764b0c22b7934142d66e.jpg");
        String url = aliyunOSSOperator.upload(FileUtil.readBytes(file), file.getName());
        System.out.println(url);
    }

}
