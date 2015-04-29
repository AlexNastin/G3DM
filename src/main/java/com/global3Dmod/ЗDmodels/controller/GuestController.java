package com.global3Dmod.�Dmodels.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.service.IGuestService;

@Controller
public class GuestController {

	@Autowired
	private IGuestService guestService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("main");
		modelAndView.addObject("listCategory",
				guestService.getAllCategoriesSubcategoriesTop3());
		return modelAndView;
	}

	@RequestMapping(value = "/go/signin", method = RequestMethod.GET)
	public ModelAndView signIn(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/signin");
		return modelAndView;
	}

	@RequestMapping(value = "/signupAddUser", method = RequestMethod.POST)
	public ModelAndView signupAddUser(SignupForm signupForm, Locale locale,
			Model model) throws Exception {

		User user = new User();
		guestService.addUser(signupForm, user);
		ModelAndView modelAndView2 = new ModelAndView("redirect:/go/signin");
		return modelAndView2;
	}

	@RequestMapping(value = "/subcategory/cartoon characters", method = RequestMethod.GET)
	public ModelAndView cartoonCharacters(Locale locale, Model model)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/signin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("about_us");
		return modelAndView;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("contact");
		return modelAndView;
	}

}
