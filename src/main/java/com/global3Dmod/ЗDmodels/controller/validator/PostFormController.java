package com.global3Dmod.ÇDmodels.controller.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.validator.PostFormValidator;

//@Controller
//@RequestMapping("/addPost")
public class PostFormController {

	@Autowired
	private PostFormValidator postValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView post(Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("&&&&&&&&&");
		PostForm postForm = new PostForm();
		modelAndView.addObject("postForm", postForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postValid(PostForm postForm, BindingResult result)
			throws Exception {

		postValidator.validate(postForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("&&&&&&&&&&&&&&");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("&&&&&&&&&&&&&");
		modelAndView.addObject("postForm", postForm);
		return modelAndView;
	}
}
