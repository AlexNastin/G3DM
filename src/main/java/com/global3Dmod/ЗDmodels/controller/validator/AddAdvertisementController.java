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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.form.AddAdvertisementForm;
import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.validator.AddAdvertisementValidator;
import com.global3Dmod.ÇDmodels.form.validator.PostFormValidator;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
@RequestMapping("/admin/addAdvertisement.html")
public class AddAdvertisementController {

	@Autowired
	private AddAdvertisementValidator addAdvertisementValidator;
	
	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView post(Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		ModelAndView modelAndView = new ModelAndView("/admin/adminAddAdvertisement");
		AddAdvertisementForm addAdvertisementForm = new AddAdvertisementForm();
		modelAndView.addObject(ControllerParamConstant.ADD_ADVERTISEMENT_FORM, addAdvertisementForm);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postValid(@ModelAttribute("addAdvertisementForm") AddAdvertisementForm addAdvertisementForm, BindingResult result, @RequestParam("advertisementPhoto") MultipartFile advertisementPhoto, HttpSession httpSession)
			throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		
		addAdvertisementForm.setAdvertisementPhoto(advertisementPhoto);
		addAdvertisementValidator.validate(addAdvertisementForm, result);

		if (result.hasErrors()) {
			User user = designerService.getUser(person.getLogin());
			userService.setPathToPhotos(user);
			ModelAndView modelAndView = new ModelAndView("/admin/adminAddAdvertisement");
			modelAndView.addObject(ControllerParamConstant.USER, user);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/admin/addAdvertisementDB");
		modelAndView.addObject(ControllerParamConstant.ADD_ADVERTISEMENT_FORM, addAdvertisementForm);
		return modelAndView;
	}
}
