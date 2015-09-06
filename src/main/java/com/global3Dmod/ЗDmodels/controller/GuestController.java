package com.global3Dmod.�Dmodels.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodels.domain.Advertisement;
import com.global3Dmod.�Dmodels.domain.Person;
import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.CommentForm;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.property.PropertyManagerG3DM;
import com.global3Dmod.�Dmodels.property.PropertyNameG3DM;
import com.global3Dmod.�Dmodels.service.IAdminService;
import com.global3Dmod.�Dmodels.service.IGuestService;
import com.global3Dmod.�Dmodels.service.IUserService;

@Controller
public class GuestController {

	@Autowired
	private MessageSource messages;

	@Autowired
	private IGuestService guestService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAdminService adminService;

	@Autowired
	private PropertyManagerG3DM propertyManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model)
			throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("main");
		modelAndView.addObject(ControllerParamConstant.LIST_CATEGORY,	
		guestService.getAllCategoriesSubcategoriesTop3());
		List<Advertisement> advertisements = guestService.getAllAdvertisement();
		adminService.setPathToPhotos(advertisements);
		modelAndView.addObject(ControllerParamConstant.LIST_ADVERTISEMENTS,
				advertisements);
		modelAndView.addObject(ControllerParamConstant.SIZE_ADVIRTISEMENTS,
				advertisements.size());
		List<Post> posts = guestService.getTop4PostsByLike();
		guestService.setRatingInPosts(posts);
		List<User> users = guestService.getTop4UsersByRating();
		userService.setPathToPhotosUsers(users);
		modelAndView.addObject(ControllerParamConstant.LIST_TOP4_USERS, users);
		userService.sortPosts(posts, "rating", false);
		modelAndView.addObject(ControllerParamConstant.LIST_TOP4_POSTS, posts);
		return modelAndView;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signIn() {
		ModelAndView modelAndView = new ModelAndView("login/signin");
		return modelAndView;
	}

	@RequestMapping(value = "/putperson", method = RequestMethod.GET)
	public ModelAndView putPerson(Locale locale, Model model,
			HttpSession httpSession) throws ServiceException {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String login = auth.getName();
		Person person = guestService.getPerson(login);
		httpSession.setAttribute(ControllerParamConstant.PERSON, person);
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView getPostsLimit10(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "idCategory", required = false) Integer idCategory,
			@RequestParam(value = "idSubcategory", required = false) Integer idSubcategory,
			Model model) throws ServiceException {
		if (page == null) {
			page = 1;
		}
		List<Post> posts;
		if (idSubcategory == null) {
			posts = guestService.getPostsByCategory(idCategory);
		} else {
			posts = guestService.getPostsByCategoryBySubcategory(idCategory,
					idSubcategory);
		}
		userService.setPathToPhotos(posts);
		guestService.setRatingInPosts(posts);
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
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject(
				ControllerParamConstant.LIST_CATEGORY_WITH_ALL_SUBCATEGORY,
				guestService.getAllCategoriesWithSubcategories());
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
		modelAndView.addObject(ControllerParamConstant.ID_CATEGORY, idCategory);
		modelAndView.addObject(ControllerParamConstant.ID_SUBCATEGORY,
				idSubcategory);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allPosts);
		return modelAndView;
	}

	@RequestMapping(value = "/signup/addUser", method = RequestMethod.POST)
	public ModelAndView signupAddUser(SignupForm signupForm, Locale locale,
			Model model) throws ServiceException {
		guestService.addUser(signupForm,
				propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		ModelAndView modelAndView = new ModelAndView("login/signin");
		String message = messages.getMessage(
				"signin.message.signup.successful", null, locale);
		modelAndView.addObject(ControllerParamConstant.MESSAGE, message);
		return modelAndView;
	}

	@RequestMapping(value = "/guest/addComment", method = RequestMethod.POST)
	public ModelAndView addComment(CommentForm commentForm, Locale locale,
			Model model, HttpSession httpSession) throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		guestService.addComment(commentForm, person);
		ModelAndView modelAndView2 = new ModelAndView("redirect:/model?id="
				+ commentForm.getIdPost());
		return modelAndView2;
	}

	@RequestMapping(value = "/guest/designerProfile", method = RequestMethod.GET)
	public ModelAndView designerProfile(
			@RequestParam(value = "id", required = false) Integer idUser,
			Locale locale, Model model) throws ServiceException {
		User user = guestService.getUser(idUser);
		List<Post> posts = user.getPosts();
		userService.setPathToPhotos(user);
		guestService.setRatingInPosts(posts);
		userService.setPathToPhotos(posts);
		ModelAndView modelAndView = new ModelAndView("designer/designerProfile");
		modelAndView.addObject(ControllerParamConstant.USER, user);
		modelAndView
				.addObject(ControllerParamConstant.SIZE_POSTS, posts.size());
		modelAndView.addObject(ControllerParamConstant.RATING_DESIGNER,
				guestService.getRatingByDesigner(idUser));
		return modelAndView;
	}
}
