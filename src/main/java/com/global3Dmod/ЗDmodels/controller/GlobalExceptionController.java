package com.global3Dmod.�Dmodels.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodels.exception.NotFoundException;
import com.global3Dmod.�Dmodels.exception.ServiceException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleResourceNotFoundException() {
		ModelAndView modelAndView = new ModelAndView("error/404");
		return modelAndView;
	}
	
	@ExceptionHandler(ServiceException.class)
	public ModelAndView handleResourceserviceException() {
		ModelAndView modelAndView = new ModelAndView("error/error");
		return modelAndView;
	}

}
