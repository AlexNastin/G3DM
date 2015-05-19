package com.global3Dmod.ÇDmodels.controller;


import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView goProfile(Locale locale, Model model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView("user/user");
		return modelAndView;
	}

}
