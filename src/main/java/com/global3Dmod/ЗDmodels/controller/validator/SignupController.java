package com.global3Dmod.ÇDmodels.controller.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodels.form.SignupForm;
import com.global3Dmod.ÇDmodels.form.validator.SignupValidator;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	private SignupValidator signupValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signup(Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/signup");
		SignupForm signupForm = new SignupForm();
		modelAndView.addObject(ControllerParamConstant.SIGNUP_FORM, signupForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSignup(SignupForm signupForm,
			BindingResult result) throws Exception {
		signupValidator.validate(signupForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("login/signup");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/signupAddUser");
		modelAndView.addObject("signupForm", signupForm);
		return modelAndView;
	}

}
