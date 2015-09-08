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
import com.global3Dmod.ÇDmodels.form.UserPersonalDataForm;
import com.global3Dmod.ÇDmodels.form.validator.UserPersonalDataValidator;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
@RequestMapping("/user/personalData/updateForm")
public class UserPersonalDataController {
	
	@Autowired
	private UserPersonalDataValidator personalDataValidator;
	
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
		User user = designerService.getUserWithCountry(person.getLogin());
		userService.setPathToPhotos(user);
		ModelAndView modelAndView = new ModelAndView("user/userPersonalDataForm");
		UserPersonalDataForm personalDataForm = new UserPersonalDataForm();
		modelAndView.addObject(ControllerParamConstant.PERSONAL_DATA_FORM, personalDataForm);
		modelAndView.addObject("listCountry", designerService.getAllCountries());
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(@ModelAttribute("personalDataForm") UserPersonalDataForm personalDataForm,
			BindingResult result, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		personalDataValidator.validate(personalDataForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("user/userPersonalDataForm");
			modelAndView.addObject("listCountry", designerService.getAllCountries());
			User user = designerService.getUserWithCountry(person.getLogin());
			userService.setPathToPhotos(user);
			modelAndView.addObject(ControllerParamConstant.USER, user);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/user/personalData/updateFormAdd");
		modelAndView.addObject("personalDataForm", personalDataForm);
		return modelAndView;
	}

}
