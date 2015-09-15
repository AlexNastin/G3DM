package com.global3Dmod.ÇDmodel.controller.validator;

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

import com.global3Dmod.ÇDmodel.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodel.domain.Person;
import com.global3Dmod.ÇDmodel.domain.Post;
import com.global3Dmod.ÇDmodel.domain.User;
import com.global3Dmod.ÇDmodel.form.UpdatePostForm;
import com.global3Dmod.ÇDmodel.form.validator.UpdatePostValidator;
import com.global3Dmod.ÇDmodel.service.IDesignerService;
import com.global3Dmod.ÇDmodel.service.IUserService;

@Controller
@RequestMapping("/designer/updatePost")
public class UpdatePostController {
	
	@Autowired
	private UpdatePostValidator updatePostValidator;
	
	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView updatePost(@RequestParam(value = "id", required = false) Integer idPost, Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		ModelAndView modelAndView = new ModelAndView("designer/designerUpdatePostForm");
		UpdatePostForm updatePostForm = new UpdatePostForm();
		modelAndView.addObject(ControllerParamConstant.UPDATE_POST_FORM, updatePostForm);
		modelAndView.addObject("listCategory", designerService.getAllCategories());
		modelAndView.addObject("listDisProgram", designerService.getAllDisPrograms());
		modelAndView.addObject("listTechnologies", designerService.getAllTechnologies());
		Post post = designerService.getPost(idPost);
		userService.setPathToPhotos(post);
		modelAndView.addObject(ControllerParamConstant.POST, post);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		modelAndView.addObject(ControllerParamConstant.ID_POST, idPost);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView personalDataValid(@RequestParam(value = "idPost", required = false) Integer idPost, UpdatePostForm updatePostForm,
			BindingResult result, HttpSession httpSession) throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		
		updatePostValidator.validate(updatePostForm, result);

		if (result.hasErrors()) {
			User user = designerService.getUser(person.getLogin());
			userService.setPathToPhotos(user);
			ModelAndView modelAndView = new ModelAndView("designer/designerUpdatePostForm");
			modelAndView.addObject("listCategory", designerService.getAllCategories());
			modelAndView.addObject("listDisProgram", designerService.getAllDisPrograms());
			modelAndView.addObject("listTechnologies", designerService.getAllTechnologies());
			Post post = designerService.getPost(idPost);
			userService.setPathToPhotos(post);
			modelAndView.addObject(ControllerParamConstant.POST, post);
			modelAndView.addObject(ControllerParamConstant.USER, user);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/designer/updatePost/updateFormAdd");
		modelAndView.addObject("updatePostForm", updatePostForm);
		return modelAndView;
	}

}
