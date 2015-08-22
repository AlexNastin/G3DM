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
import com.global3Dmod.ÇDmodels.form.RejectMessageForm;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.IModeratorService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
public class ModeratorController {

	@Autowired
	private IModeratorService moderatorService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IDesignerService designerService;

	@RequestMapping(value = "/moderator/profile", method = RequestMethod.GET)
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
		if (sort == null) {
			sort = "date";
		}
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;

		ModelAndView modelAndView = new ModelAndView("moderator/moderator");
		List<Post> posts = moderatorService.getPostsByModeratingForSort();
		moderatorService.sortPosts(posts, sort, desc);
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
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
		modelAndView = moderatorService.setParamsForSort(modelAndView, sort,
				desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/moderator/rejectingPosts", method = RequestMethod.GET)
	public ModelAndView rejectingPosts(
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
				"moderator/moderatorRejectingPosts");
		List<Post> posts = moderatorService.getPostsByRejectingForSort();
		moderatorService.sortPosts(posts, sort, desc);
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
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
		modelAndView = moderatorService.setParamsForSort(modelAndView, sort,
				desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(value = "/moderator/publishPost", method = RequestMethod.GET)
	public ModelAndView publishPost(
			@RequestParam(value = "id", required = false) Integer idPost,
			Locale locale, Model model) throws ServiceException {
		moderatorService.publishPost(idPost);
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/moderator/profile");
		return modelAndView;
	}

	@RequestMapping(value = "/moderator/zeroingComplainPost", method = RequestMethod.GET)
	public ModelAndView zeroingComplainPost(
			@RequestParam(value = "id", required = false) Integer idPost,
			Locale locale, Model model) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("redirect:/moderator/complainedPosts");
		moderatorService.removeComplainsPost(idPost);
		return modelAndView;
	}

	@RequestMapping(value = "/moderator/addRejectMessage", method = RequestMethod.POST)
	public ModelAndView addRejectMessage(RejectMessageForm rejectMessageForm,
			Locale locale, Model model, HttpSession httpSession)
			throws ServiceException {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		moderatorService.addRejectMessage(rejectMessageForm, person);
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/moderator/profile");
		return modelAndView;
	}

	@RequestMapping(value = "/moderator/complainedPosts", method = RequestMethod.GET)
	public ModelAndView complainedPosts(
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
		if (sort == null) {
			sort = "complain";
		}
		int startPage = page - 5 > 0 ? page - 5 : 1;
		int endPage = startPage + 9;

		ModelAndView modelAndView = new ModelAndView(
				"moderator/moderatorComplainedPosts");
		List<Post> posts = moderatorService.getComplainedPostsForSort();
		moderatorService.setComplainInPosts(posts);
		moderatorService.sortPosts(posts, sort, desc);
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
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
		modelAndView = moderatorService.setParamsForSort(modelAndView, sort,
				desc);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

}
