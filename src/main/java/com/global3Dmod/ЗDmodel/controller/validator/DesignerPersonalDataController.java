package com.global3Dmod.�Dmodel.controller.validator;

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

import com.global3Dmod.�Dmodel.controller.ControllerParamConstant;
import com.global3Dmod.�Dmodel.domain.Person;
import com.global3Dmod.�Dmodel.domain.User;
import com.global3Dmod.�Dmodel.form.DesignerPersonalDataForm;
import com.global3Dmod.�Dmodel.form.validator.DesignerPersonalDataValidator;
import com.global3Dmod.�Dmodel.service.IDesignerService;
import com.global3Dmod.�Dmodel.service.IUserService;

@Controller
@RequestMapping("/designer/personalData/updateForm")
public class DesignerPersonalDataController {
	
	@Autowired
	private DesignerPersonalDataValidator personalDataValidator;
	
	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalData(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("designer/designerPersonalDataForm");
		DesignerPersonalDataForm personalDataForm = new DesignerPersonalDataForm();
		modelAndView.addObject(ControllerParamConstant.PERSONAL_DATA_FORM, personalDataForm);
		modelAndView.addObject("listCountry", designerService.getAllCountries());
		User user = designerService.getUserWithCountry(person.getLogin());
		userService.setPathToPhotos(user);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(@ModelAttribute("personalDataForm") DesignerPersonalDataForm personalDataForm,
			BindingResult result, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		personalDataValidator.validate(personalDataForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("designer/designerPersonalDataForm");
			modelAndView.addObject("listCountry", designerService.getAllCountries());
			User user = designerService.getUserWithCountry(person.getLogin());
			userService.setPathToPhotos(user);
			modelAndView.addObject(ControllerParamConstant.USER, user);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/designer/personalData/updateFormAdd");
		modelAndView.addObject("personalDataForm", personalDataForm);
		return modelAndView;
	}

}
