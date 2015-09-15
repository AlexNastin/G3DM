package com.global3Dmod.ÇDmodel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodel.domain.Person;
import com.global3Dmod.ÇDmodel.exception.ServiceException;
import com.global3Dmod.ÇDmodel.service.IGuestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LikeController {

	@Autowired
	private IGuestService guestService;

	@RequestMapping(value = "/like", method = RequestMethod.GET)
	public ModelAndView like(Model model,
			@RequestParam(value = "id", required = false) Integer idPost,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		guestService.vote(person.getIdPerson(), idPost);

		ModelAndView modelAndView = new ModelAndView("redirect:/model?id="
				+ idPost);
		return modelAndView;
	}

}
