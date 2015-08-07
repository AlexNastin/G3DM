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

import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.AddAdvertisementForm;
import com.global3Dmod.ÇDmodels.form.AddModeratorForm;
import com.global3Dmod.ÇDmodels.form.UpdateAdvertisementForm;
import com.global3Dmod.ÇDmodels.property.PropertyManagerG3DM;
import com.global3Dmod.ÇDmodels.property.PropertyNameG3DM;
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

	@Autowired
	private PropertyManagerG3DM propertyManager;

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
		modelAndView.addObject(ControllerParamConstant.SIZE_USERS, allUsers);
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
		modelAndView.addObject(ControllerParamConstant.SIZE_USERS, allUsers);
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
		modelAndView.addObject(ControllerParamConstant.SIZE_USERS, allUsers);
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

		ModelAndView modelAndView = new ModelAndView(
				"admin/adminAdvertisements");
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		List<Advertisement> advertisements = adminService
				.getAdvertisementsForSort();
		adminService.sortAdvertisements(advertisements, sort, desc);
		int allAdvertisement = advertisements.size();
		int maxPage = (int) Math.ceil((double) allAdvertisement
				/ ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE);
		int startAdvertisement = page
				* ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE
				- ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE;
		int endAdvertisement = startAdvertisement
				+ ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE;
		if (endAdvertisement > startAdvertisement) {
			advertisements = advertisements.subList(startAdvertisement,
					allAdvertisement);
		} else {
			advertisements = advertisements.subList(startAdvertisement,
					allAdvertisement);
		}
		adminService.setPathToPhotos(advertisements);
		modelAndView.addObject(
				ControllerParamConstant.LIST_ADVERTISEMENTS_LIMIT_10,
				advertisements);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if (endPage > maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_ADVIRTISEMENTS,
				allAdvertisement);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if (desc) {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = adminService.setParamsAdvertisementForSort(modelAndView,
				sort, desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/addAdvertisementDB", method = RequestMethod.POST)
	public ModelAndView addPostDB(AddAdvertisementForm addAdvertisementForm,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.addAdvertisement(addAdvertisementForm,
				propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView2 = new ModelAndView(
				"redirect:/admin/advertisements");
		return modelAndView2;
	}

	@RequestMapping(value = "/admin/updateAdvertisementAdd", method = RequestMethod.POST)
	public ModelAndView updateAdvertisementAdd(
			UpdateAdvertisementForm updateAdvertisementForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.updateAdvertisement(updateAdvertisementForm,
				propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView2 = new ModelAndView(
				"redirect:/admin/updateAdvertisement.html?id="
						+ updateAdvertisementForm.getIdAdvertisement());
		return modelAndView2;
	}

	@RequestMapping(value = "/admin/addModertor", method = RequestMethod.POST)
	public ModelAndView addModertor(AddModeratorForm addModeratorForm)
			throws ServiceException {
		guestService.addModerator(addModeratorForm);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/profile");
		return modelAndView;

	}

	@RequestMapping(value = "/admin/deleteAdvertisement.html", method = RequestMethod.GET)
	public ModelAndView deletePost(
			@RequestParam(value = "id", required = false) Integer idAdvertisement,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.deleteAdvertisement(idAdvertisement);
		ModelAndView modelAndView2 = new ModelAndView(
				"redirect:/admin/advertisements");
		return modelAndView2;
	}

	@RequestMapping(value = "/admin/formTopDesigners", method = RequestMethod.GET)
	public ModelAndView formTopDesigners(Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.formTopDesigners();
		ModelAndView modelAndView2 = new ModelAndView(
				"forward:/admin/designers");
		modelAndView2.addObject(ControllerParamConstant.MESSAGE, true);
		return modelAndView2;
	}

	@RequestMapping(value = "/admin/deleteModerator", method = RequestMethod.GET)
	public ModelAndView deleteModerator(
			@RequestParam(value = "id", required = false) Integer idUser)
			throws ServiceException {
		System.out.println();
		adminService.deleteModerator(idUser);
		ModelAndView modelAndView2 = new ModelAndView("redirect:/admin/profile");
		return modelAndView2;
	}
}
