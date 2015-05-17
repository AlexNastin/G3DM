package com.global3Dmod.�Dmodels.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

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

import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.domain.Person;
import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.Subcategory;
import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.PostForm;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.service.IDesignerService;

@Controller
public class DesignerController {

	@Autowired
	private IDesignerService designerService;

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
	// // ��� ������ ���� �� ������???
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
	public ModelAndView d(Locale locale, Model model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		ModelAndView modelAndView = new ModelAndView("designer/designer");
		List<Post> posts = designerService.getPostsByDesigner(person.getIdPerson());
		modelAndView.addObject("listPostsByDesigner", posts);
		return modelAndView;
	}

	@RequestMapping(value = "/addPostDB", method = RequestMethod.POST)
	public ModelAndView addPostDB(PostForm postForm, Locale locale, Model model, HttpSession httpSession)
			throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		designerService.addPost(postForm, person.getIdPerson());
		ModelAndView modelAndView2 = new ModelAndView("redirect:/index");
		return modelAndView2;
	}

	@RequestMapping(value = "/getStringMVC", method = RequestMethod.GET)
	public String addPostDB() throws Exception {

		return "AAAABBBBBCCCCC";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(Locale locale, Model model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("designer/postsByDesigner");
		List<Post> posts = designerService.getPostsByDesigner(3);
		modelAndView.addObject("listPostsByDesigner", posts);
		return modelAndView;
	}

	@RequestMapping(value = "/get/subcategories", method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> getAllSubcategoryWithinCategory(
			@RequestParam(value = "idCategory", required = true) Integer idCategory)
			throws ServiceException {
		return designerService.getAllSubcategoryWithinCategory(idCategory);
	}

	@RequestMapping(value = "/get/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory() throws ServiceException {
		return designerService.getAllCategories();
	}
}
