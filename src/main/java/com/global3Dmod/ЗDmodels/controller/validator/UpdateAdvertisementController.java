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
import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.form.UpdateAdvertisementForm;
import com.global3Dmod.ÇDmodels.form.validator.UpdateAdvertisementValidator;
import com.global3Dmod.ÇDmodels.service.IAdminService;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
@RequestMapping("/admin/updateAdvertisement.html")
public class UpdateAdvertisementController {

	@Autowired
	private UpdateAdvertisementValidator updateAdvertisementValidator;
	
	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView advertisement(@RequestParam(value = "id", required = false) Integer idAdvertisement, Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		Advertisement advertisement = adminService.getAdvertisement(idAdvertisement);
		adminService.setPathToPhotos(advertisement);
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		ModelAndView modelAndView = new ModelAndView("/admin/adminUpdateAdvertisement");
		UpdateAdvertisementForm updateAdvertisementForm = new UpdateAdvertisementForm();
		modelAndView.addObject(ControllerParamConstant.ADVERTISEMENT, advertisement);
		modelAndView.addObject(ControllerParamConstant.UPDATE_ADVERTISEMENT_FORM, updateAdvertisementForm);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postValid(@RequestParam(value = "id", required = false) Integer idAdvertisement, @ModelAttribute("updateAdvertisementForm") UpdateAdvertisementForm updateAdvertisementForm, BindingResult result, @RequestParam("advertisementPhoto") MultipartFile advertisementPhoto, HttpSession httpSession)
			throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		
		updateAdvertisementForm.setAdvertisementPhoto(advertisementPhoto);
		updateAdvertisementValidator.validate(updateAdvertisementForm, result);

		if (result.hasErrors()) {
			User user = designerService.getUser(person.getLogin());
			userService.setPathToPhotos(user);
			Advertisement advertisement = adminService.getAdvertisement(idAdvertisement);
			adminService.setPathToPhotos(advertisement);
			ModelAndView modelAndView = new ModelAndView("/admin/adminUpdateAdvertisement");
			modelAndView.addObject(ControllerParamConstant.ADVERTISEMENT, advertisement);
			modelAndView.addObject(ControllerParamConstant.USER, user);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/admin/updateAdvertisementAdd");
		modelAndView.addObject(ControllerParamConstant.UPDATE_ADVERTISEMENT_FORM, updateAdvertisementForm);
		return modelAndView;
	}
}
