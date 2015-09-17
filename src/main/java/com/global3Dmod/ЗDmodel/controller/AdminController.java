package com.global3Dmod.ÇDmodel.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodel.domain.Advertisement;
import com.global3Dmod.ÇDmodel.domain.Person;
import com.global3Dmod.ÇDmodel.domain.User;
import com.global3Dmod.ÇDmodel.exception.ServiceException;
import com.global3Dmod.ÇDmodel.form.AddAdvertisementForm;
import com.global3Dmod.ÇDmodel.form.AddModeratorForm;
import com.global3Dmod.ÇDmodel.form.UpdateAdvertisementForm;
import com.global3Dmod.ÇDmodel.property.PropertyManagerG3DM;
import com.global3Dmod.ÇDmodel.property.PropertyNameG3DM;
import com.global3Dmod.ÇDmodel.service.IAdminService;
import com.global3Dmod.ÇDmodel.service.IDesignerService;
import com.global3Dmod.ÇDmodel.service.IGuestService;
import com.global3Dmod.ÇDmodel.service.IUserService;

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
	public ModelAndView goProfile(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc, Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
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
		int maxPage = (int) Math.ceil((double) allUsers / ControllerParamConstant.LIMIT_USERS_ON_PAGE);
		int startUser = page * ControllerParamConstant.LIMIT_USERS_ON_PAGE
				- ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		int endUser = startUser + ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		if (endUser > startUser) {
			users = users.subList(startUser, allUsers);
		} else {
			users = users.subList(startUser, allUsers);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_LIMIT_20, users);
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
	public ModelAndView goDesigners(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc, Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
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
		int maxPage = (int) Math.ceil((double) allUsers / ControllerParamConstant.LIMIT_USERS_ON_PAGE);
		int startUser = page * ControllerParamConstant.LIMIT_USERS_ON_PAGE
				- ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		int endUser = startUser + ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		if (endUser > startUser) {
			users = users.subList(startUser, allUsers);
		} else {
			users = users.subList(startUser, allUsers);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_LIMIT_20, users);
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
	public ModelAndView goUsers(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc, Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
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
		int maxPage = (int) Math.ceil((double) allUsers / ControllerParamConstant.LIMIT_USERS_ON_PAGE);
		int startUser = page * ControllerParamConstant.LIMIT_USERS_ON_PAGE
				- ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		int endUser = startUser + ControllerParamConstant.LIMIT_USERS_ON_PAGE;
		if (endUser > startUser) {
			users = users.subList(startUser, allUsers);
		} else {
			users = users.subList(startUser, allUsers);
		}
		modelAndView.addObject(ControllerParamConstant.LIST_USERS_LIMIT_20, users);
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
	public ModelAndView goAdvertisements(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "desc", required = false) boolean desc, Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		if (page == null) {
			page = 1;
		}
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;

		ModelAndView modelAndView = new ModelAndView("admin/adminAdvertisements");
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		List<Advertisement> advertisements = adminService.getAdvertisementsForSort();
		adminService.sortAdvertisements(advertisements, sort, desc);
		int allAdvertisement = advertisements.size();
		int maxPage = (int) Math.ceil((double) allAdvertisement / ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE);
		int startAdvertisement = page * ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE
				- ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE;
		int endAdvertisement = startAdvertisement + ControllerParamConstant.LIMIT_ADVERTISEMENTS_ON_PAGE;
		if (endAdvertisement > startAdvertisement) {
			advertisements = advertisements.subList(startAdvertisement, allAdvertisement);
		} else {
			advertisements = advertisements.subList(startAdvertisement, allAdvertisement);
		}
		adminService.setPathToPhotos(advertisements);
		modelAndView.addObject(ControllerParamConstant.LIST_ADVERTISEMENTS_LIMIT_10, advertisements);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if (endPage > maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_ADVIRTISEMENTS, allAdvertisement);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if (desc) {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = adminService.setParamsAdvertisementForSort(modelAndView, sort, desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/addAdvertisementDB", method = RequestMethod.POST)
	public ModelAndView addPostDB(AddAdvertisementForm addAdvertisementForm, Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.addAdvertisement(addAdvertisementForm, propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/advertisements");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/updateAdvertisementAdd", method = RequestMethod.POST)
	public ModelAndView updateAdvertisementAdd(UpdateAdvertisementForm updateAdvertisementForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.updateAdvertisement(updateAdvertisementForm, propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/admin/updateAdvertisement.html?id=" + updateAdvertisementForm.getIdAdvertisement());
		return modelAndView;
	}

	@RequestMapping(value = "/admin/addModertor", method = RequestMethod.POST)
	public ModelAndView addModertor(AddModeratorForm addModeratorForm) throws ServiceException {
		guestService.addModerator(addModeratorForm);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/profile");
		return modelAndView;

	}

	@RequestMapping(value = "/admin/deleteAdvertisement.html", method = RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam(value = "id", required = false) Integer idAdvertisement, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.deleteAdvertisement(idAdvertisement);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/advertisements");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/formTopDesigners", method = RequestMethod.GET)
	public ModelAndView formTopDesigners(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		adminService.formTopDesigners();
		ModelAndView modelAndView = new ModelAndView("forward:/admin/designers");
		modelAndView.addObject(ControllerParamConstant.MESSAGE, true);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/deleteModerator", method = RequestMethod.GET)
	public ModelAndView deleteModerator(@RequestParam(value = "id", required = false) Integer idUser)
			throws ServiceException {
		adminService.deleteModerator(idUser);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/profile");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/addDefaultAdvertisement", method = RequestMethod.GET)
	public ModelAndView addDefaultAdvertisement() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/advertisements");
		adminService.addDefaultAdvertisement();
		return modelAndView;
	}

	@RequestMapping(value = "/admin/statistic", method = RequestMethod.GET)
	public ModelAndView statistic(Locale locale, Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("admin/adminStatistic");
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		int allUsers = adminService.getNumberOfAllUsers();
		int designers = adminService.getNumberOfDesigners();
		int moderators = adminService.getNumberOfModerators();
		int admins = adminService.getNumberOfAdmins();
		int users = adminService.getNumberOfUsers();
		int allPosts = adminService.getNumberOfAllPosts();
		int deletedPosts = adminService.getNumberOfDeletedPosts();
		int rejectedPosts = adminService.getNumberOfRejectedPosts();
		int moderatingPosts = adminService.getNumberOfModeratingPosts();
		int publishingPosts = adminService.getNumberOfPublishingPosts();
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_ALL_USERS, allUsers);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_DESIGNERS, designers);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_MODERATORS, moderators);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_ADMINS, admins);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_USERS, users);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_ALL_POSTS, allPosts);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_DELETED_POSTS, deletedPosts);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_REJECTED_POSTS, rejectedPosts);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_MODERATING_POSTS, moderatingPosts);
		modelAndView.addObject(ControllerParamConstant.NUMBER_OF_PUBLISHING_POSTS, publishingPosts);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/admin/test", method = RequestMethod.GET)
	public ModelAndView testJMagick() throws IOException {
//test swing
		URL url = new URL("https://content.onliner.by/news/2015/09/default/4b22d0394be1a6426908d30535c58791.jpg");
		final BufferedImage bi = ImageIO.read(url);

		Runnable r = new Runnable() {
			public void run() {
				JLabel unresize = new JLabel(new ImageIcon(bi));

				int width = (int) (bi.getWidth() * .75);
				int height = (int) (bi.getHeight() * .75);

				BufferedImage bi1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g1 = bi1.getGraphics();
				g1.drawImage(bi, 0, 0, width, height, null);
				JLabel easyResize = new JLabel(new ImageIcon(bi1));

				JPanel p = new JPanel();
				p.add(unresize);
				p.add(easyResize);

				JOptionPane.showMessageDialog(null, p);
			}
		};
		SwingUtilities.invokeLater(r);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/advertisements");
		return modelAndView;
	}

}
