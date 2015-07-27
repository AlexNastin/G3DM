package com.global3Dmod.ÇDmodels.controller.validator;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalSecurityForm;
import com.global3Dmod.ÇDmodels.form.validator.DesignerPersonalDataValidator;
import com.global3Dmod.ÇDmodels.form.validator.DesignerPersonalSecurityValidator;
import com.global3Dmod.ÇDmodels.service.IDesignerService;

@Controller
@RequestMapping("/designer/personalSecurity")
public class DesignerPersonalSecurityController {
	
	@Autowired
	private DesignerPersonalSecurityValidator personalSecurityValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalSecurity(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("designer/designerPersonalSecurityForm");
		DesignerPersonalSecurityForm personalSecurityForm = new DesignerPersonalSecurityForm();
		modelAndView.addObject(ControllerParamConstant.PERSONAL_SECURITY_FORM, personalSecurityForm);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(@ModelAttribute("personalSecurityForm") DesignerPersonalSecurityForm personalSecurityForm,
			BindingResult result) throws Exception {
		personalSecurityValidator.validate(personalSecurityForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("designer/designerPersonalSecurityForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/designer/personalSecurity/updatePasswordFormAdd");
		modelAndView.addObject("personalSecurityForm", personalSecurityForm);
		return modelAndView;
	}

}
