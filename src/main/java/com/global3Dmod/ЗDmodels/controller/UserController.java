package com.global3Dmod.ÇDmodels.controller;


import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Person;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView u(Locale locale, Model model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		System.out.println(person+ "USER JSP");
		ModelAndView modelAndView = new ModelAndView("user/user");
		return modelAndView;
	}

}
