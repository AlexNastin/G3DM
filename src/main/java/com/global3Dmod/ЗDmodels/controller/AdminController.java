package com.global3Dmod.ÇDmodels.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.exception.ServiceException;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
	public ModelAndView goProfile() {
		ModelAndView modelAndView = new ModelAndView("admin/admin");
		return modelAndView;
	}

	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public ModelAndView goProfile(Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		throw new ServiceException("exception SERVISE");
	}

}
