package com.global3Dmod.ÇDmodels.controller.validator;

import java.io.File;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.validator.PostFormValidator;
import com.global3Dmod.ÇDmodels.service.IDesignerService;

@Controller
@RequestMapping("/addPost")
public class PostFormController {

	@Autowired
	private PostFormValidator postValidator;
	
	@Autowired
	private IDesignerService designerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView post(Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("designer/addPost");
		PostForm postForm = new PostForm();
		modelAndView.addObject("postForm", postForm);
		modelAndView.addObject("listDisProgram", designerService.getAllDisPrograms());
		modelAndView.addObject("listCategory", designerService.getAllCategories());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postValid(PostForm postForm, BindingResult result, @RequestParam("file") MultipartFile file)
			throws Exception {

		postValidator.validate(postForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("designer/addPost");
			return modelAndView;
		}
		System.out.println("File uploaded.");

		String orgName = file.getOriginalFilename();

		final String PREFIX = this.getClass().getResource("/").getPath();
//		C:\Java\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\G3DM\resources\files
		System.out.println(PREFIX);
		// Êàê çàäàòü ïóòü íå æåñòêî???
		String filePlaceToUpload = "C:/Users/User/git/G3DM/src/main/webapp/resources/files/";
		String filePath = filePlaceToUpload + orgName;
		File dest = new File(filePath);
		file.transferTo(dest);
		postForm.setFilePath(filePath);
		ModelAndView modelAndView = new ModelAndView("forward:/addPostDB");
		modelAndView.addObject("postForm", postForm);
		return modelAndView;
	}
}
