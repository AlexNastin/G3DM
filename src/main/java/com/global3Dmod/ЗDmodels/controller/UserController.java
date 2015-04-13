package com.global3Dmod.ÇDmodels.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.global3Dmod.ÇDmodels.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {


	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(Locale locale, Model model) throws Exception {
	// logger.info("Welcome home! The client locale is {}.", locale);
	// Date date = new Date();
	// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
	// DateFormat.LONG, locale);
	//
	// String formattedDate = dateFormat.format(date);
	// if (formattedDate != null) {
	// model.addAttribute("userList", userService.getAllUsers());
	// model.addAttribute("userTop", userService.getTop3Users());
	// model.addAttribute("serverTime", formattedDate);
	// throw new Exception("OLOLO");
	// }
	// return "main";
	// }
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(Locale locale, Model model) {
	// logger.info("Welcome home! The client locale is {}.", locale);
	// Date date = new Date();
	// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
	// DateFormat.LONG, locale);
	//
	// String formattedDate = dateFormat.format(date);
	//
	// model.addAttribute("userList", userService.getAllUsers());
	// model.addAttribute("userTop", userService.getTop3Users());
	// model.addAttribute("serverTime", formattedDate);
	//
	// return "home";
	// }

}
