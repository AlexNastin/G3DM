package com.global3Dmod.ÇDmodels.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DAOAnnotationAspect {

	private static final Logger LOGGER = Logger
			.getLogger(DAOAnnotationAspect.class);

	@Around("@annotation(com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM)")
	public Object proceeding(JoinPoint joinPoint) {
	
		Object value = null;
		
		String nameClass = joinPoint.getSignature().getName();
		String nameMethod = joinPoint.getSourceLocation().getWithinType()
				.getName();
	
		LOGGER.info("Start execute. " + "method: " + nameMethod + "class: "
				+ nameClass);
		System.out.println("Start execute. " + "method: " + nameMethod
				+ "class: " + nameClass);
		try {
			value = ((ProceedingJoinPoint) joinPoint).proceed();
		} catch (Throwable e) {
			LOGGER.error("Exception when the  methods. " + "method: "
					+ nameMethod + "class: " + nameClass, e.getCause());
			System.out.println("Exception when the  methods. " + "method: "
					+ nameMethod + "class: " + nameClass);

		}
		LOGGER.info("End execute. " + "method: " + nameMethod + "class: "
				+ nameClass);
		System.out.println("End execute. " + "method: " + nameMethod
				+ "class: " + nameClass);
		return value;
	}

	// @Before(value =
	// "@within(com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM) || @annotation(com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM)")
	// @Before("@annotation(com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM)")
	// public void proceedings(JoinPoint joinPoint){
	// String nameClass = joinPoint.getSignature().getName();
	// String nameMethod =
	// joinPoint.getSourceLocation().getWithinType().getName();
	// System.out.println(nameClass +" " + nameMethod);
	// System.out.println("ASSADASDA");
	//
	//
	// }
}
