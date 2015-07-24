package com.global3Dmod.�Dmodels.controller.validator;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodels.controller.ControllerParamConstant;
import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.domain.Person;
import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.�Dmodels.form.UpdatePostForm;
import com.global3Dmod.�Dmodels.form.validator.DesignerPersonalDataValidator;
import com.global3Dmod.�Dmodels.form.validator.UpdatePostValidator;
import com.global3Dmod.�Dmodels.service.IDesignerService;

@Controller
@RequestMapping("/designer/updatePost")
public class UpdatePostController {
	
	@Autowired
	private UpdatePostValidator updatePostValidator;
	
	@Autowired
	private IDesignerService designerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView updatePost(@RequestParam(value = "id", required = false) Integer idPost, Locale locale, ModelMap model) throws Exception {
		ModelAndView modelAndView = new ModelAndView("designer/designerUpdatePostForm");
		UpdatePostForm updatePostForm = new UpdatePostForm();
		modelAndView.addObject(ControllerParamConstant.UPDATE_POST_FORM, updatePostForm);
		modelAndView.addObject("listCategory", designerService.getAllCategories());
		modelAndView.addObject("listDisProgram", designerService.getAllDisPrograms());
		modelAndView.addObject("listTechnologies", designerService.getAllTechnologies());
		Post post = designerService.getPost(idPost);
		modelAndView.addObject(ControllerParamConstant.POST, post);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(UpdatePostForm updatePostForm,
			BindingResult result) throws Exception {
		updatePostValidator.validate(updatePostForm, result);

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("designer/designerUpdatePostForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/designer/updatePost/updateFormAdd");
		modelAndView.addObject("updatePostForm", updatePostForm);
		return modelAndView;
	}

}
