package com.global3Dmod.ÇDmodels.controller;

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
		Person person = guestService.getPerson(login);
		httpSession.setAttribute(ControllerParamConstant.PERSON, person);
		ModelAndView modelAndView = new ModelAndView("redirect:/index");
		return modelAndView;
	}
	
	// Test
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	  public ModelAndView getPostsLimit10(@RequestParam(value = "page", required = false) Integer page, Model model) throws Exception {
		int startPage = page - 5 > 0?page - 5:1;
	    int endPage = startPage + 9;
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_LIMIT_10, guestService.getPostsLimit10(page));
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
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
