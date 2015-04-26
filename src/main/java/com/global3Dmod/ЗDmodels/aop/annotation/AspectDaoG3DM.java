package com.global3Dmod.ÇDmodels.aop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import org.springframework.stereotype.Component;


@Component
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectDaoG3DM {

}
