package com.global3Dmod.ÇDmodels.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.form.SignupForm;
import com.global3Dmod.ÇDmodels.service.IGuestService;

@Controller
public class GuestController {

	@Autowired
	private IGuestService guestService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView main(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("main");
		modelAndView.addObject(ControllerParamConstant.LIST_CATEGORY, guestService.getAllCategoriesSubcategoriesTop3());
		modelAndView.addObject(ControllerParamConstant.LIST_ADVERTISEMENTS, guestService.getAllAdvertisement());
		return modelAndView;
	}

	@RequestMapping(value = "/go/signin", method = RequestMethod.GET)
	public ModelAndView signIn(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("login/signin");
		return modelAndView;
	}
	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ModelAndView jobs(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("jobs");
		return modelAndView;
	}

	@RequestMapping(value = "/putperson", method = RequestMethod.GET)
	public ModelAndView putPerson(Locale locale, Model model,
			HttpSession httpSession) throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String login = auth.getName();
		System.out.println(login);
		Person person = guestService.getPerson(login);
		System.out.println(person);
		httpSession.setAttribute(ControllerParamConstant.PERSON, person);
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}
	
//	@RequestMapping(value = "/result/category", method = RequestMethod.GET)
//	  public ModelAndView getPostsLimit10(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "idCategory", required = false) Integer idCategory, Model model) throws Exception {
//		if (page == null) {
//			page=1;
//		}
//		List<Post> posts = guestService.getPostsLimit10ByCategory(page, idCategory);
//		int startPage = page - 5 > 0?page - 5:1;
//	    int endPage = startPage + 9;
//		ModelAndView modelAndView = new ModelAndView("result");
//		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_LIMIT_10, posts);
//		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
//		modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
//		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
//	    return modelAndView;
//	  }
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	  public ModelAndView getPostsLimit10BySubcategory(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "idCategory", required = false) Integer idCategory, @RequestParam(value = "idSubcategory", required = false) Integer idSubcategory, Model model) throws Exception {
		if (page == null) {
			page=1;
		}
		List<Post> posts;
		if(idSubcategory == null) {
			posts = guestService.getPostsLimit10ByCategory(page, idCategory);
		} else {
			posts = guestService.getPostsLimit10BySubcategory(page, idCategory, idSubcategory);
		}
		int allPosts = posts.size();
	    int maxPage = (int) Math.ceil((double)allPosts / ControllerParamConstant.LIMIT_POSTS_ON_PAGE);
		int startPost = page * ControllerParamConstant.LIMIT_POSTS_ON_PAGE - ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		int endPost = startPost + ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		if(endPost>allPosts) {
			posts = posts.subList(startPost, allPosts);
		} else {
			posts = posts.subList(startPost, endPost);
		}
		int startPage = page - 5 > 0?page - 5:1;
	    int endPage = startPage + 9;
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_LIMIT_10, posts);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if(endPage>maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.ID_CATEGORY, idCategory);
		modelAndView.addObject(ControllerParamConstant.ID_SUBCATEGORY, idSubcategory);
		modelAndView.addObject(ControllerParamConstant.SIZE_POSTS, allPosts);
	    return modelAndView;
	  }
	
	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public ModelAndView model(@RequestParam(value = "id", required = false) Integer idPost, Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("model");
		Post post = guestService.getPost(idPost);
		modelAndView.addObject(ControllerParamConstant.POST, post);
		return modelAndView;
	}

	@RequestMapping(value = "/signupAddUser", method = RequestMethod.POST)
	public ModelAndView signupAddUser(SignupForm signupForm, Locale locale,
			Model model) throws Exception {
		guestService.addUser(signupForm);
		ModelAndView modelAndView2 = new ModelAndView("redirect:/go/signin");
		return modelAndView2;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("about_us");
		return modelAndView;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("contact");
		return modelAndView;
	}

	@RequestMapping("403page")
	public ModelAndView ge403denied() {
		ModelAndView modelAndView = new ModelAndView("error/403page");
		return modelAndView;
	}
}
