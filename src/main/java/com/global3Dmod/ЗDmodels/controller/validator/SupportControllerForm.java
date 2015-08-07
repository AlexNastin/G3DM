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
import com.global3Dmod.ÇDmodels.form.SupportForm;
import com.global3Dmod.ÇDmodels.form.validator.SupportValidator;

@Controller
@RequestMapping("/support")
public class SupportControllerForm {

	@Autowired
	private SupportValidator supportValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView support(Locale locale, ModelMap model) throws Exception {
		SupportForm supportForm = new SupportForm();
		ModelAndView modelAndView = new ModelAndView("others/support");
		modelAndView.addObject(ControllerParamConstant.SUPPORT_FORM, supportForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSignup(SupportForm supportForm,
			BindingResult result) throws Exception {
		supportValidator.validate(supportForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("others/support");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/supportEmailSend");
		return modelAndView;
	}
}
