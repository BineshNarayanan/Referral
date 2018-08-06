package com.referral.api.aspect.exception;

import com.referral.api.dto.page.PageCriteria;
import com.referral.api.service.exception.InvalidDataRequestException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class DataRequestValidationAspect {

    @Before("execution(* com.referral.api.service.impl.*.*.findAll(..))")
    public void validateFindAll(JoinPoint joinPoint){
        PageCriteria pageCriteria = (PageCriteria) joinPoint.getArgs()[0];
        if(pageCriteria.getSize() > 1000){
            throw new InvalidDataRequestException("API cannot more than 1000 records at once. Please check requested page size of your request.");
        }
    }
}
