package com.global3Dmod.ÇDmodels.controller.validator;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodels.form.UpdateForgotPasswordForm;
import com.global3Dmod.ÇDmodels.form.validator.UpdateForgotPasswordValidator;

@Controller
@RequestMapping("/updatePassword")
public class UpdateForgotPasswordController {

	
	@Autowired
	private UpdateForgotPasswordValidator updateForgotPasswordValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalSecurity(@RequestParam("id") int id, Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/updatePassword");
		UpdateForgotPasswordForm updateForgotPasswordForm = new UpdateForgotPasswordForm();
		modelAndView.addObject(ControllerParamConstant.UPDATE_FORGOT_PASSWORD, updateForgotPasswordForm);
		modelAndView.addObject("id", id);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(UpdateForgotPasswordForm updateForgotPasswordForm,
			BindingResult result) throws Exception {
		
		updateForgotPasswordValidator.validate(updateForgotPasswordForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("login/updatePassword");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/savePassword");
		modelAndView.addObject("password", updateForgotPasswordForm.getPassword());
		return modelAndView;
	}
	
}
