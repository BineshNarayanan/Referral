package com.referral.api.aspect.logging;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Aspect
@Configuration
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.referral.api.controller.*.*(..))" +
            " || execution(* com.referral.api.controller.*.*.*(..))" +
            " || execution(* com.referral.api.service.impl.*.*.*(..))" +
            " || execution(* com.referral.api.persistence.*.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        try {
            log.info("Executing {}.{}", className, methodName);
            log.debug("Start time : {}", DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
            log.debug("Executing with args {}.{}({})", className, methodName, args);
            Object ret = joinPoint.proceed();
            log.debug("End time : {}", DateFormatUtils.format(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
            return ret;
        } catch (Error e) {
            log.error("Error while executing {}.{}({})",className, methodName, args);
            log.error("Details are : {}", getStackTrace(e));
            throw e;
        } catch (Exception e) {
            log.error("Exception while executing {}.{}({})",className, methodName, args);
            log.error("Details are : {}", getStackTrace(e));
            throw e;
        }
    }

}
