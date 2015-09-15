package com.global3Dmod.ÇDmodel.controller.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodel.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodel.form.UpdateForgotPasswordForm;
import com.global3Dmod.ÇDmodel.form.validator.UpdateForgotPasswordValidator;

@Controller
@RequestMapping("/secure/updatePassword")
public class UpdateForgotPasswordController {

	@Autowired
	private UpdateForgotPasswordValidator updateForgotPasswordValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalSecurity(Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/updatePassword");
		UpdateForgotPasswordForm updateForgotPasswordForm = new UpdateForgotPasswordForm();
		modelAndView.addObject(ControllerParamConstant.UPDATE_FORGOT_PASSWORD_FORM, updateForgotPasswordForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(@ModelAttribute("updateForgotPasswordForm") UpdateForgotPasswordForm updateForgotPasswordForm,
			BindingResult result) throws Exception {
		updateForgotPasswordValidator
				.validate(updateForgotPasswordForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("login/updatePassword");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/secure/savePassword");
		modelAndView.addObject("password", updateForgotPasswordForm.getPassword());
		return modelAndView;
	}

}
