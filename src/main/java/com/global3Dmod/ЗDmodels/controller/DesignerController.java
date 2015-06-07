package com.global3Dmod.ÇDmodels.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.Subcategory;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.SignupForm;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByCategory;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDate;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDownloads;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByStatus;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsBySubcategory;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitle;

@Controller
public class DesignerController {

	@Autowired
	private IDesignerService designerService;

	// ÍÈÊÈÒÀ ÒÅÁÅ ÝÒÎ ÍÓÆÍî?????
	// @RequestMapping(value = "/upload", method = RequestMethod.POST)
	// public String handleUpload(@RequestParam("description") String
	// description,
	// @RequestParam("file") MultipartFile file) throws Exception{
	// if (!file.isEmpty()) {
	// System.out.println("File uploaded.");
	// System.out.println("Description: " + description);
	//
	// String orgName = file.getOriginalFilename();
	//
	// final String PREFIX = this.getClass().getResource("/").getPath();
	// //
	// C:\Java\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\G3DM\resources\files
	// System.out.println(PREFIX);
	// // Êàê çàäàòü ïóòü íå æåñòêî???
	// String filePlaceToUpload =
	// "C:/Java/workspasdasdasdasdasdasdace/G3DM/src/main/webapp/resources/files/";
	// String filePath = filePlaceToUpload + orgName;
	// File dest = new File(filePath);
	//
	//
	// file.transferTo(dest);
	//
	// return "main";
	// } else {
	// return "test";
	// }
	// }

	@RequestMapping(value = "/designer/profile", method = RequestMethod.GET)
	public ModelAndView goProfile(@RequestParam(value = "page", required = false) Integer page,@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "desc", required = false) boolean desc, Locale locale, Model model, HttpSession httpSession)
			throws Exception {
		if (page == null) {
			page=1;
		}
		int startPage = page - 5 > 0?page - 5:1;
	    int endPage = startPage + 9;
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("designer/designer");
		List<Post> posts = designerService.getPostsByDesignerForSort(person.getIdPerson());
		designerService.sortPosts(posts, sort, desc);
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
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_BY_DESIGNER, posts);
		modelAndView.addObject(ControllerParamConstant.SORT_TYPE, sort);
		if(desc){
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, true);
		} else {
			modelAndView.addObject(ControllerParamConstant.DESC_PAGE, false);
		}
		modelAndView = designerService.setParamsForSort(modelAndView, sort, desc);
		return modelAndView;
	}

	@RequestMapping(value = "/designer/addPostDB", method = RequestMethod.POST)
	public ModelAndView addPostDB(PostForm postForm, Locale locale,
			Model model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession
				.getAttribute(ControllerParamConstant.PERSON);
		designerService.addPost(postForm, person.getIdPerson(),
				person.getNickName());
		ModelAndView modelAndView2 = new ModelAndView("redirect:/designer/profile");
		return modelAndView2;
	}
	
	@RequestMapping(value = "/designer/designerProfile", method = RequestMethod.GET)
	public ModelAndView designerPrifile(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("designer/designerProfile");
		return modelAndView;
	}

	// Test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("designer/postsByDesigner");
		List<Post> posts = designerService.getPostsByDesigner(3);
		modelAndView.addObject(ControllerParamConstant.LIST_POSTS_BY_DESIGNER,
				posts);
		return modelAndView;
	}
	
	@RequestMapping(value = "/designer/personalData", method = RequestMethod.GET)
	public ModelAndView personalData(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("designer/designerPersonalData");
		return modelAndView;
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@RequestMapping(value = "/get/subcategories", method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> getAllSubcategoryWithinCategory(
			@RequestParam(value = "idCategory", required = true) Integer idCategory)
			throws ServiceException {
		List<Subcategory> subcategories = designerService.getAllSubcategoryWithinCategory(idCategory);
		for (Subcategory subcategory : subcategories) {
			System.out.println(subcategory.getTitle());
		}
		return subcategories;
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@RequestMapping(value = "/get/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory()
			throws ServiceException {
		return designerService.getAllCategories();
	}
}
