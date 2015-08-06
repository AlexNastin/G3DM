package com.global3Dmod.ÇDmodels.controller;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.exception.ServiceException;

@Controller
@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ServiceException.class)
	public ModelAndView handleResourceServiceException() {
		ModelAndView modelAndView = new ModelAndView("error/errorService");
		return modelAndView;
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleError405() {
		ModelAndView modelAndView = new ModelAndView("error/error");
		return modelAndView;
	}

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleResourceException() {
		ModelAndView modelAndView = new ModelAndView("error/error");
		return modelAndView;
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ModelAndView handleFileNotFoundException() {
		ModelAndView modelAndView = new ModelAndView("error/error");
		return modelAndView;
	}
}
