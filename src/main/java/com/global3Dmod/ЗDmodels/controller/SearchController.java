package com.global3Dmod.ÇDmodels.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.search.PostSearch;
import com.global3Dmod.ÇDmodels.service.IGuestService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
public class SearchController {

	@Autowired
	private IGuestService guestService;

	@Autowired
	private IUserService userService;

	@Autowired
	private PostSearch postSearch;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView index(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "text", required = false) String text)
			throws Exception {

		if (!"".equals(text)) {

		}

		if (page == null) {
			page = 1;
		}
		List<Post> posts = new ArrayList<Post>();
		if (!"".equals(text)) {
			posts = postSearch.search(text);
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
		ModelAndView modelAndView = new ModelAndView("search");
		modelAndView.addObject(ControllerParamConstant.TEXT, text);
		modelAndView.addObject(
				ControllerParamConstant.LIST_CATEGORY_WITH_ALL_SUBCATEGORY,
				guestService.getAllCategories());
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
		return modelAndView;

	}

}
