package com.global3Dmod.ÇDmodels.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.exception.ServiceException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ServiceException.class)
	public ModelAndView handleResourceServiceException() {
		ModelAndView modelAndView = new ModelAndView("error/errorService");
		return modelAndView;
	}

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleResourceException() {
		ModelAndView modelAndView = new ModelAndView("error/error");
		return modelAndView;
	}

}
