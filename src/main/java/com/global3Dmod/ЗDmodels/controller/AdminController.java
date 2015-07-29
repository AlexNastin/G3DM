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
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.AddModeratorForm;
import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.service.IAdminService;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IGuestService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
public class AdminController {

	@Autowired
	private IDesignerService designerService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAdminService adminService;

	@Autowired
	private IGuestService guestService;

	@RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
	public ModelAndView goProfile(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		if (page == null) {
			page = 1;
		}
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;

		ModelAndView modelAndView = new ModelAndView("admin/admin");
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		List<User> users = adminService.getModeratorsForSort();
		adminService.sortUsers(users, sort, desc);
		int allUsers = users.size();
		int maxPage = (int) Math.ceil((double) allUsers
				/ ControllerParamConstant.LIMIT_USERS_ON_PAGE);
		int startUser = page * ControllerParamConstant.LIMIT_USERS_ON_PAGE
				- ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		int endUser = startUser + ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		if (endUser > startUser) {
			users = users.subList(startUser, allUsers);
		} else {
			users = users.subList(startUser, allUsers);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_LIMIT_20,
				users);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if (endPage > maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allUsers);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if (desc) {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = adminService.setParamsForSort(modelAndView, sort, desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/designers", method = RequestMethod.GET)
	public ModelAndView goDesigners(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		if (page == null) {
			page = 1;
		}
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;

		ModelAndView modelAndView = new ModelAndView("admin/adminDesigners");
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		List<User> users = adminService.getDesignersForSort();
		adminService.sortUsers(users, sort, desc);
		int allUsers = users.size();
		int maxPage = (int) Math.ceil((double) allUsers
				/ ControllerParamConstant.LIMIT_USERS_ON_PAGE);
		int startUser = page * ControllerParamConstant.LIMIT_USERS_ON_PAGE
				- ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		int endUser = startUser + ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		if (endUser > startUser) {
			users = users.subList(startUser, allUsers);
		} else {
			users = users.subList(startUser, allUsers);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_LIMIT_20,
				users);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if (endPage > maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allUsers);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if (desc) {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = adminService.setParamsForSort(modelAndView, sort, desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public ModelAndView goUsers(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		if (page == null) {
			page = 1;
		}
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;

		ModelAndView modelAndView = new ModelAndView("admin/adminUsers");
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		List<User> users = adminService.getUsersForSort();
		adminService.sortUsers(users, sort, desc);
		int allUsers = users.size();
		int maxPage = (int) Math.ceil((double) allUsers
				/ ControllerParamConstant.LIMIT_USERS_ON_PAGE);
		int startUser = page * ControllerParamConstant.LIMIT_USERS_ON_PAGE
				- ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		int endUser = startUser + ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		if (endUser > startUser) {
			users = users.subList(startUser, allUsers);
		} else {
			users = users.subList(startUser, allUsers);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_LIMIT_20,
				users);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if (endPage > maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allUsers);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if (desc) {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = adminService.setParamsForSort(modelAndView, sort, desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/advertisements", method = RequestMethod.GET)
	public ModelAndView goAdvertisements(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		if (page == null) {
			page = 1;
		}
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;

		ModelAndView modelAndView = new ModelAndView("admin/adminDesigners");
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		List<User> users = adminService.getDesignersForSort();
		adminService.sortUsers(users, sort, desc);
		int allUsers = users.size();
		int maxPage = (int) Math.ceil((double) allUsers
				/ ControllerParamConstant.LIMIT_USERS_ON_PAGE);
		int startUser = page * ControllerParamConstant.LIMIT_USERS_ON_PAGE
				- ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		int endUser = startUser + ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		if (endUser > startUser) {
			users = users.subList(startUser, allUsers);
		} else {
			users = users.subList(startUser, allUsers);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_LIMIT_20,
				users);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if (endPage > maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allUsers);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if (desc) {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = adminService.setParamsForSort(modelAndView, sort, desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	// test
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public ModelAndView goProfile(Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		throw new ServiceException("exception SERVISE");
	}

	@RequestMapping(value = "/admin/addModertor", method = RequestMethod.POST)
	public ModelAndView addModertor(AddModeratorForm addModeratorForm)
			throws ServiceException {
		guestService.addModerator(addModeratorForm);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/profile");
		return modelAndView;

	}

}
