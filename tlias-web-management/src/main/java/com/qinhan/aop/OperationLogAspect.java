package com.qinhan.aop;

import com.qinhan.mapper.OperateLogMapper;
import com.qinhan.pojo.OperateLog;
import com.qinhan.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.qinhan.anno.Log)")
    public Object logOperation(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = pjp.proceed();

        // 计算耗时
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        // 构建日志实体
        OperateLog olog = new OperateLog();
        olog.setOperateEmpId(getCurrentUserId());
        olog.setOperateTime(LocalDateTime.now());
        olog.setClassName(pjp.getClass().getName());
        olog.setMethodName(pjp.getSignature().getName());
        olog.setMethodParams(Arrays.toString(pjp.getArgs()));
        olog.setReturnValue(result != null ? result.toString() : "void" );
        olog.setCostTime(costTime);

        // 保存日志
        log.info("记录操作日志:{}",olog);
        operateLogMapper.insert(olog);

        return result;

    }

    private Integer getCurrentUserId(){
        return CurrentHolder.getCurrentId();
    }
}
