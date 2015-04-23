package com.global3Dmod.ÇDmodels.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	private static final Logger logger = Logger
			.getLogger(GlobalExceptionController.class);

//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleAllException(Exception ex) {
//		ModelAndView model = new ModelAndView("error/generic_error");
//		model.addObject("errCode", "");
//		model.addObject("errMsg", "SS");
//		logger.error(ex);
//		return model;
//	}
}
