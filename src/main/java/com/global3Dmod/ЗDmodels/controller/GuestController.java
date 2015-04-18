package com.global3Dmod.ÇDmodels.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
public class GuestController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("main");
		return modelAndView;
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	 public String home(Locale locale, Model model) throws Exception {
//	  return "main";
//	 }
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("");
		return modelAndView;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("test");
		return modelAndView;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signIn(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/signin");
		return modelAndView;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView registration(Locale locale, Model model)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/signup");
		return modelAndView;
	}
}
