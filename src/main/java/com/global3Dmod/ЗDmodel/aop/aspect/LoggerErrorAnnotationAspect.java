package com.global3Dmod.ÇDmodel.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerErrorAnnotationAspect {

	private static final Logger LOGGER = Logger.getLogger(LoggerErrorAnnotationAspect.class);

	@Around("@annotation(com.global3Dmod.ÇDmodel.aop.annotation.AspectLogG3DM)")
	public Object proceeding(JoinPoint joinPoint) {
		Object value = null;
		
		try {
			value = ((ProceedingJoinPoint) joinPoint).proceed();
		} catch (Throwable e) {
			StringBuilder builder = new StringBuilder(joinPoint.getTarget().getClass().toString());
			builder.append(" Name method: ");
			builder.append(joinPoint.getSignature().getName());
			LOGGER.error(builder.toString(), e);
		}
		return value;
	}
}
