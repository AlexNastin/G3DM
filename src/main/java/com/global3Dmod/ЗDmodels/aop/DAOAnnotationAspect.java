package com.global3Dmod.ÇDmodels.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class DAOAnnotationAspect {

	private static final Logger logger = Logger
			.getLogger(DAOAnnotationAspect.class);

	@Around("@annotation(com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM)")
    public Object proceeding(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before invoking getName() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After invoking getName() method. Return value="+value);
        return value;
    }
}
