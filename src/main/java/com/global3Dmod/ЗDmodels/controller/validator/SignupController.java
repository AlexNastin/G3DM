package com.global3Dmod.ÇDmodels.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.global3Dmod.ÇDmodels.form.SignupForm;
import com.global3Dmod.ÇDmodels.form.validator.SignupValidator;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	private SignupValidator signupValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String signup(ModelMap model) {
		SignupForm signupForm = new SignupForm();
		model.put("signupForm", signupForm);
		return "login/signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSignup(SignupForm signupForm, BindingResult result) {
		signupValidator.validate(signupForm, result);
		if (result.hasErrors()) {
			return "login/signup";
		}
		return "main";
	}

}
