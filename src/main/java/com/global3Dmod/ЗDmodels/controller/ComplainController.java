package com.global3Dmod.ÇDmodels.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.service.IGuestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ComplainController {

	@Autowired
	private IGuestService guestService;

	@RequestMapping(value = "/complain", method = RequestMethod.GET)
	public ModelAndView complain(Model model,
			@RequestParam(value = "id", required = false) Integer idPost,
			HttpSession httpSession) throws Exception {

		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		guestService.complain(person.getIdPerson(), idPost);

		ModelAndView modelAndView = new ModelAndView("redirect:/model?id="
				+ idPost);
		return modelAndView;
	}

}
