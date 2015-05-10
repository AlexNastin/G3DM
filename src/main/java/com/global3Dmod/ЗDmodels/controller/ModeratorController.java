package com.global3Dmod.�Dmodels.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModeratorController {
	
	@RequestMapping(value = "/moderator/userstable", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("moderator/userstable");
		return modelAndView;
	}
	
	@RequestMapping(value = "/moderator/profile", method = RequestMethod.GET)
	public ModelAndView a(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("moderator/moderator");
		return modelAndView;
	}

}

