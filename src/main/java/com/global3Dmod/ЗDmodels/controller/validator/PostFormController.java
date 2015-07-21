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

import com.global3Dmod.ÇDmodels.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.validator.PostFormValidator;
import com.global3Dmod.ÇDmodels.service.IDesignerService;

@Controller
@RequestMapping("/designer/addPost")
public class PostFormController {

	@Autowired
	private PostFormValidator postValidator;
	
	@Autowired
	private IDesignerService designerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView post(Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("designer/addPost");
		PostForm postForm = new PostForm();
		modelAndView.addObject(ControllerParamConstant.POST_FORM, postForm);
		modelAndView.addObject("listDisProgram", designerService.getAllDisPrograms());
		modelAndView.addObject("listCategory", designerService.getAllCategories());
		modelAndView.addObject("listTechnologies", designerService.getAllTechnologies());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postValid(PostForm postForm, BindingResult result, @RequestParam("model") MultipartFile model, 
			@RequestParam("firstPhoto") MultipartFile firstPhoto)
			throws Exception {
		
		postForm.setModel(model);
		postForm.setFirstPhoto(firstPhoto);
		postValidator.validate(postForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("designer/addPost");
			modelAndView.addObject("listDisProgram", designerService.getAllDisPrograms());
			modelAndView.addObject("listCategory", designerService.getAllCategories());
			modelAndView.addObject("listTechnologies", designerService.getAllTechnologies());
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/designer/addPostDB");
		modelAndView.addObject("postForm", postForm);
		return modelAndView;
	}
}
