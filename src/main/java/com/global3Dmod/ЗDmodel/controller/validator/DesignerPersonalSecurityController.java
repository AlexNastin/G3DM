package com.global3Dmod.ÇDmodel.controller.validator;

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

import com.global3Dmod.ÇDmodel.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodel.domain.Person;
import com.global3Dmod.ÇDmodel.domain.User;
import com.global3Dmod.ÇDmodel.form.DesignerPersonalSecurityForm;
import com.global3Dmod.ÇDmodel.form.validator.DesignerPersonalSecurityValidator;
import com.global3Dmod.ÇDmodel.service.IDesignerService;
import com.global3Dmod.ÇDmodel.service.IUserService;

@Controller
@RequestMapping("/designer/secure/personalSecurity")
public class DesignerPersonalSecurityController {
	
	@Autowired
	private DesignerPersonalSecurityValidator personalSecurityValidator;
	
	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView personalSecurity(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		ModelAndView modelAndView = new ModelAndView("designer/designerPersonalSecurityForm");
		DesignerPersonalSecurityForm personalSecurityForm = new DesignerPersonalSecurityForm();
		modelAndView.addObject(ControllerParamConstant.PERSONAL_SECURITY_FORM, personalSecurityForm);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(@ModelAttribute("personalSecurityForm") DesignerPersonalSecurityForm personalSecurityForm,
			BindingResult result, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		
		personalSecurityValidator.validate(personalSecurityForm, result);

		if (result.hasErrors()) {
			User user = designerService.getUser(person.getLogin());
			userService.setPathToPhotos(user);
			ModelAndView modelAndView = new ModelAndView("designer/designerPersonalSecurityForm");
			modelAndView.addObject(ControllerParamConstant.USER, user);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/designer/secure/personalSecurity/updatePasswordFormAdd");
		modelAndView.addObject("personalSecurityForm", personalSecurityForm);
		return modelAndView;
	}

}
