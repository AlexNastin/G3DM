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
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.form.PersonalDataForm;
import com.global3Dmod.ÇDmodels.form.validator.PersonalDataValidator;
import com.global3Dmod.ÇDmodels.service.IDesignerService;

@Controller
@RequestMapping("/designer/personalData/updateForm")
public class PersonalDataController {
	
	@Autowired
	private PersonalDataValidator personalDataValidator;
	
	@Autowired
	private IDesignerService designerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signup(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("designer/designerPersonalDataForm");
		PersonalDataForm personalDataForm = new PersonalDataForm();
		modelAndView.addObject("personalDataForm", personalDataForm);
		modelAndView.addObject("listCountry", designerService.getAllCountries());
		User user = designerService.getUser(person.getLogin());
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSignup(PersonalDataForm personalDataForm,
			BindingResult result) throws Exception {
		personalDataValidator.validate(personalDataForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("designer/designerPersonalDataForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/designer/personalData/updateFormAdd");
		modelAndView.addObject("personalDataForm", personalDataForm);
		return modelAndView;
	}

}
