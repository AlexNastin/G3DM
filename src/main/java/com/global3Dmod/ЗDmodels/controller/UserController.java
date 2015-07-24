package com.global3Dmod.ÇDmodels.controller;


import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalSecurityForm;
import com.global3Dmod.ÇDmodels.form.UserPersonalDataForm;
import com.global3Dmod.ÇDmodels.form.UserPersonalSecurityForm;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IGuestService;
import com.global3Dmod.ÇDmodels.service.IUserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGuestService guestService;
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView goProfile(@RequestParam(value = "page", required = false) Integer page,@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "desc", required = false) boolean desc, Locale locale, Model model, HttpSession httpSession)
			throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		if (page == null) {
			page=1;
		}
		int startPage = page - 5 > 0?page - 5:1;
	    int endPage = startPage + 9;
	
		ModelAndView modelAndView = new ModelAndView("user/user");
		List<Post> posts = userService.getPostsByUserForSort(person.getIdPerson());
		guestService.setRatingInPosts(posts);
		userService.sortPosts(posts, sort, desc);
		int allPosts = posts.size();
	    int maxPage = (int) Math.ceil((double)allPosts / ControllerParamConstant.LIMIT_POSTS_ON_PAGE);
		int startPost = page * ControllerParamConstant.LIMIT_POSTS_ON_PAGE - ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		int endPost = startPost + ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		if(endPost>allPosts) {
			posts = posts.subList(startPost, allPosts);
		} else {
			posts = posts.subList(startPost, endPost);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_LIMIT_10, posts);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if(endPage>maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allPosts);
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_BY_DESIGNER, posts);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if(desc){
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = userService.setParamsForSort(modelAndView, sort, desc);
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/personalData", method = RequestMethod.GET)
	public ModelAndView personalData(Locale locale, Model model,
			HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView(
				"user/userPersonalData");
		User user = designerService.getUser(person.getLogin());
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/personalData/updateFormAdd", method = RequestMethod.POST)
	public ModelAndView updateFormAdd(UserPersonalDataForm personalDataForm,
			Locale locale, Model model, HttpSession httpSession)
			throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		userService.updateUser(personalDataForm, person.getLogin());
		ModelAndView modelAndView2 = new ModelAndView(
				"redirect:/user/personalData/updateForm");
		return modelAndView2;
	}
	
	@RequestMapping(value = "/user/personalSecurity/updatePasswordFormAdd", method = RequestMethod.POST)
	public ModelAndView updatePasswordFormAdd(
			UserPersonalSecurityForm personalSecurityForm, Locale locale,
			Model model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		userService.updatePassword(personalSecurityForm, person.getLogin());

		ModelAndView modelAndView2 = new ModelAndView(
				"/user/personalSecurity");
		modelAndView2.addObject("updatePasswordSuccessfully", "successfully");
		return modelAndView2;
	}

}
