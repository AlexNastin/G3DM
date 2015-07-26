package com.global3Dmod.ÇDmodels.controller.validator;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.form.UserPersonalSecurityForm;
import com.global3Dmod.ÇDmodels.form.validator.UserPersonalSecurityValidator;

@Controller
@RequestMapping("/user/personalSecurity")
public class UserPersonalSecurityController {
	
	@Autowired
	private UserPersonalSecurityValidator personalSecurityValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalSecurity(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("user/userPersonalSecurityForm");
		UserPersonalSecurityForm personalSecurityForm = new UserPersonalSecurityForm();
		modelAndView.addObject(ControllerParamConstant.PERSONAL_SECURITY_FORM, personalSecurityForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(UserPersonalSecurityForm personalSecurityForm,
			BindingResult result) throws Exception {
		personalSecurityValidator.validate(personalSecurityForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("user/userPersonalSecurityForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/user/personalSecurity/updatePasswordFormAdd");
		modelAndView.addObject("personalSecurityForm", personalSecurityForm);
		return modelAndView;
	}

}
