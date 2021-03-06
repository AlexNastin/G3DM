package com.global3Dmod.�Dmodel.controller.validator;

import java.util.Locale;






import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodel.controller.ControllerParamConstant;
import com.global3Dmod.�Dmodel.domain.Person;
import com.global3Dmod.�Dmodel.domain.Post;
import com.global3Dmod.�Dmodel.domain.User;
import com.global3Dmod.�Dmodel.form.RejectMessageForm;
import com.global3Dmod.�Dmodel.form.validator.RejectMessageValidator;
import com.global3Dmod.�Dmodel.service.IDesignerService;
import com.global3Dmod.�Dmodel.service.IUserService;

@Controller
@RequestMapping("/moderator/moderationComplainPost")
public class ComplainRejectMessageController {
	
	@Autowired
	private RejectMessageValidator rejectMessageValidator;
	
	@Autowired
	private IDesignerService designerService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView rejectPost(@RequestParam(value = "id", required = false) Integer idPost, Locale locale, Model model, HttpSession httpSession)
			throws Exception {
		Person person = (Person) httpSession.getAttribute(ControllerParamConstant.PERSON);
		if (person == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/putperson");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("moderator/moderatorComplainPost");
		Post post = designerService.getPost(idPost);
		userService.setPathToPhotos(post);
		User user = designerService.getUser(person.getLogin());
		userService.setPathToPhotos(user);
		RejectMessageForm rejectMessageForm = new RejectMessageForm();
		modelAndView.addObject(ControllerParamConstant.REJECT_MESSAGE_FORM, rejectMessageForm);
		modelAndView.addObject(ControllerParamConstant.POST, post);
		modelAndView.addObject(ControllerParamConstant.USER, user);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView rejectPostValid(RejectMessageForm rejectMessageForm,
			BindingResult result) throws Exception {
		rejectMessageValidator.validate(rejectMessageForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("redirect:/moderator/moderationComplainPost?id=" + rejectMessageForm.getIdPost());
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/moderator/addRejectMessage");
		modelAndView.addObject(ControllerParamConstant.REJECT_MESSAGE_FORM, rejectMessageForm);
		return modelAndView;
	}

}
