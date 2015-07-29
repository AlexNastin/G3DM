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
import com.global3Dmod.ÇDmodels.form.AddModeratorForm;
import com.global3Dmod.ÇDmodels.form.validator.AddModeratorValidator;

@Controller
@RequestMapping("/admin/addModerator.html")
public class AdminAddModeratorForm {

	@Autowired
	AddModeratorValidator addModeratorValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signup(Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("admin/adminAddModerator");
		AddModeratorForm addModeratorForm = new AddModeratorForm();
		modelAndView.addObject(ControllerParamConstant.ADD_MODERATOR_FORM, addModeratorForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSignup(AddModeratorForm addModeratorForm,
			BindingResult result) {
		addModeratorValidator.validate(addModeratorForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("admin/adminAddModerator");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/admin/addModertor");
		modelAndView.addObject(ControllerParamConstant.ADD_MODERATOR_FORM, addModeratorForm);
		return modelAndView;
	}

}
