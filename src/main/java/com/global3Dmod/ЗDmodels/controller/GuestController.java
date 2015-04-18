package com.global3Dmod.ÇDmodels.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.form.SignupForm;
import com.global3Dmod.ÇDmodels.form.validator.SignupValidator;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
public class GuestController {

	@Autowired
	private IUserService userService;
	
	private SignupValidator signupValidator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("main");
		return modelAndView;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("test");
		return modelAndView;
	}

	@RequestMapping(value = "/go/signin", method = RequestMethod.GET)
	public ModelAndView signIn(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/signin");
		return modelAndView;
	}

//	@RequestMapping(value = "/go/signup", method = RequestMethod.GET)
//	public ModelAndView goRegistration(Locale locale, Model model)
//			throws Exception {
//		ModelAndView modelAndView = new ModelAndView("login/signup2");
//		modelAndView.addObject("signupForm", new SignupForm());
//		return modelAndView;
//	}
//
//	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	public String processSignup(SignupForm signupForm, BindingResult result) {
//		signupValidator.validate(signupForm, result);
//		if (result.hasErrors()) {
//			return "login/signup2";
//		}
//		return "main";
//	}
}
