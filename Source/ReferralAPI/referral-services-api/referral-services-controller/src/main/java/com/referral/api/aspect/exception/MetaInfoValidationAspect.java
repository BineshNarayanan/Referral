package com.referral.api.aspect.exception;

import com.referral.api.dto.BaseDTO;
import com.referral.api.service.exception.InvalidMetaInfoException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class MetaInfoValidationAspect {

    @Before("execution(* com.referral.api.service.impl.*.*.save*(..))")
    public void validateSaveForMetaInfo(JoinPoint joinPoint){
        BaseDTO pageCriteria = (BaseDTO) joinPoint.getArgs()[0];
        if(StringUtils.isEmpty(pageCriteria.getCreatedBy()) || StringUtils.isEmpty(pageCriteria.getUpdatedBy())){
            throw new InvalidMetaInfoException("CreatedBy/UpdatedBy Information is mandatory for Add & Update requests");
        }
    }

    @Before("execution(* com.referral.api.service.impl.*.*.delete*(..))")
    public void validateDeleteForMetaInfo(JoinPoint joinPoint){
        BaseDTO pageCriteria = (BaseDTO) joinPoint.getArgs()[0];
        if(StringUtils.isEmpty(pageCriteria.getUpdatedBy())){
            throw new InvalidMetaInfoException("UpdatedBy Information is mandatory for Delete requests");
        }
    }
}
