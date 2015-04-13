package com.global3Dmod.ÇDmodels.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
public class GuestController {

	private static final Logger logger = Logger.getLogger(GuestController.class);
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		if (formattedDate != null) {
			throw new Exception();
		}
		return "main";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) throws Exception {
		return "test";
	}

}
