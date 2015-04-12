package com.global3Dmod.ÇDmodels.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		System.out.println(ex.getLocalizedMessage());
		System.out.println( ex.getMessage());
		model.addObject("errCode",ex.getLocalizedMessage());
		model.addObject("errMsg", ex.getMessage());
		return model;

	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Order")
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(Exception ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode","202");
		model.addObject("errMsg", "this is Exception.classss");
		return model;

	}
}
