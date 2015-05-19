package com.global3Dmod.ÇDmodels.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.User;

@Controller
public class ModeratorController {
	
	@RequestMapping(value = "/moderator/userstable", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView("moderator/userstable");
		return modelAndView;
	}
	
	@RequestMapping(value = "/moderator/profile", method = RequestMethod.GET)
	public ModelAndView goProfile(Locale locale, Model model, @ModelAttribute User user, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView("moderator/moderator");
		return modelAndView;
	}

}

