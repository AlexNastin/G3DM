package com.global3Dmod.�Dmodel.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.global3Dmod.�Dmodel.domain.Category;
import com.global3Dmod.�Dmodel.domain.City;
import com.global3Dmod.�Dmodel.domain.Country;
import com.global3Dmod.�Dmodel.domain.Person;
import com.global3Dmod.�Dmodel.domain.Post;
import com.global3Dmod.�Dmodel.domain.Subcategory;
import com.global3Dmod.�Dmodel.domain.User;
import com.global3Dmod.�Dmodel.exception.ServiceException;
import com.global3Dmod.�Dmodel.form.DesignerPersonalDataForm;
import com.global3Dmod.�Dmodel.form.DesignerPersonalSecurityForm;
import com.global3Dmod.�Dmodel.form.PostForm;
import com.global3Dmod.�Dmodel.form.UpdatePostForm;
import com.global3Dmod.�Dmodel.property.PropertyManagerG3DM;
import com.global3Dmod.�Dmodel.property.PropertyNameG3DM;
import com.global3Dmod.�Dmodel.service.IDesignerService;
import com.global3Dmod.�Dmodel.service.IUserService;

@Controller
public class DesignerController {

	@Autowired
	private MessageSource messages;

	@Autowired
	private IDesignerService designerService;

	@Autowired
	private PropertyManagerG3DM propertyManager;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/designer/profile", method = RequestMethod.GET)
	public ModelAndView goProfile(HttpServletRequest request,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc,
			Locale locale, Model model, HttpSession httpSession)  throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		if (page == null) {
			page = 1;
		}
		if (sort == null) {
			sort = "date";
		}
		
	
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		List<Post> posts  = designerService.getPostsByDesignerForSort(person.getIdPerson());
		designerService.sortPosts(posts, sort, desc);

		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;
		ModelAndView modelAndView = new ModelAndView("designer/designer");

		int allPosts = posts.size();
		int maxPage = (int) Math.ceil((double) allPosts
				/ ControllerParamConstant.LIMIT_POSTS_ON_PAGE);
		int startPost = page * ControllerParamConstant.LIMIT_POSTS_ON_PAGE
				- ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		int endPost = startPost + ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		if (endPost > allPosts) {
			posts = posts.subList(startPost, allPosts);
		} else {
			posts = posts.subList(startPost, endPost);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_LIMIT_10,
				posts);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if (endPage > maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allPosts);
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_BY_DESIGNER,
				posts);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if (desc) {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		try {

			modelAndView = designerService.setParamsForSort(modelAndView, sort,
					desc);
		} catch (ServiceException e) {

		}
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/designer/addPostDB", method = RequestMethod.POST)
	public ModelAndView addPostDB(PostForm postForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		designerService.addPost(postForm, person.getIdPerson(),
				person.getNickName(),
				propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/designer/profile");
		return modelAndView;
	}

	@RequestMapping(value = "/designer/deletePost", method = RequestMethod.GET)
	public ModelAndView deletePost(
			@RequestParam(value = "id", required = false) Integer idPost,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		designerService.deletePost(idPost);
		ModelAndView modelAndView2 = new ModelAndView(
				"redirect:/designer/profile");
		return modelAndView2;
	}

	@RequestMapping(value = "/designer/personalData/updateFormAdd", method = RequestMethod.POST)
	public ModelAndView updateFormAdd(
			DesignerPersonalDataForm personalDataForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		designerService.updateUser(personalDataForm, person.getLogin(),
				propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/designer/personalData/updateForm");
		return modelAndView;
	}

	@RequestMapping(value = "/designer/updatePost/updateFormAdd", method = RequestMethod.POST)
	public ModelAndView updatePostFormAdd(UpdatePostForm updatePostForm,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		System.out.println(updatePostForm.getModelUpdate().getName());
		System.out.println(updatePostForm.getFirstPhotoUpdate().getName());
		designerService.updatePost(updatePostForm, updatePostForm.getIdPost(),
				propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/designer/updatePost?id="
						+ updatePostForm.getIdPost());
		return modelAndView;
	}

	@RequestMapping(value = "/designer/secure/personalSecurity/updatePasswordFormAdd", method = RequestMethod.POST)
	public ModelAndView updatePasswordFormAdd(
			DesignerPersonalSecurityForm personalSecurityForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		designerService.updatePassword(personalSecurityForm, person.getLogin());

		ModelAndView modelAndView = new ModelAndView(
				"designer/designerPersonalSecurityForm");
		String message = messages.getMessage(
				"email.message.resetpaswordsuccessful", null, locale);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		return modelAndView;
	}

	@RequestMapping(value = "/designer/personalData", method = RequestMethod.GET)
	public ModelAndView personalData(Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView(
				"designer/designerPersonalData");
		User user = designerService.getUserWithCountry(person.getLogin());
		userService.setPathToPhotos(user);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/designer/deleteAvatar", method = RequestMethod.GET)
	public ModelAndView deleteAvatar(Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		String message = messages.getMessage("users.message.deleteAvatar",
				null, locale);
		User user = designerService.getUserWithCountry(person.getLogin());
		designerService.deleteAvatar(user.getAvatar());
		ModelAndView modelAndView = new ModelAndView(
				"designer/designerPersonalData");
		userService.setPathToPhotos(user);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		return modelAndView;
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@RequestMapping(value = "/get/subcategories", method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> getAllSubcategoryWithinCategory(
			@RequestParam(value = "idCategory", required = true) Integer idCategory)
			throws ServiceException {
		List<Subcategory> subcategories = designerService
				.getAllSubcategoryWithinCategory(idCategory);
		return subcategories;
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@RequestMapping(value = "/get/countries", method = RequestMethod.GET)
	public @ResponseBody List<Country> getAllCountry() throws ServiceException {
		List<Country> countries = designerService.getAllCountries();
		designerService.sortCountries(countries);
		return countries;
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@RequestMapping(value = "/get/cities", method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCityWithinCountry(
			@RequestParam(value = "idCountry", required = true) Integer idCountry)
			throws ServiceException {
		List<City> cities = designerService.getAllCityWithinCountry(idCountry);
		return cities;
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@RequestMapping(value = "/get/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory()
			throws ServiceException {
		return designerService.getAllCategories();
	}
}
