package com.global3Dmod.ÇDmodels.controller.validator;

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

import com.global3Dmod.ÇDmodels.controller.ControllerParamConstant;
import com.global3Dmod.ÇDmodels.domain.Comment;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.form.CommentForm;
import com.global3Dmod.ÇDmodels.form.validator.CommentValidator;
import com.global3Dmod.ÇDmodels.service.IGuestService;
import com.global3Dmod.ÇDmodels.service.IUserService;

@Controller
@RequestMapping("/model")
public class ModelController {
	
	@Autowired
	private CommentValidator commentValidator;
	
	@Autowired
	private IGuestService guestService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView comment(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "id", required = false) Integer idPost,Locale locale, ModelMap model, HttpSession httpSession) throws Exception {
		ModelAndView modelAndView = new ModelAndView("model/model");
		Post post = guestService.getPost(idPost);
		if(post.getIsDisplay() == 2 || post.getIsDisplay() == 1) {
			modelAndView = new ModelAndView("model/modelOnModeration");
			return modelAndView;
		} else if(post.getIsDisplay() == 0) {
			modelAndView = new ModelAndView("model/modelDeleted");
			return modelAndView;
		}
		userService.setPathToPhotos(post);
		CommentForm commentForm = new CommentForm();
		if (page == null) {
			page=1;
		}
		int startPage = page - 5 > 0?page - 5:1;
	    int endPage = startPage + 9;
		List<Comment> comments = guestService.getCommentsByPost(idPost);
		guestService.sortCommentsByDate(comments);
	    int allComments = comments.size();
	    int maxPage = (int) Math.ceil((double)allComments / ControllerParamConstant.LIMIT_POSTS_ON_PAGE);
		int startPost = page * ControllerParamConstant.LIMIT_POSTS_ON_PAGE - ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		int endPost = startPost + ControllerParamConstant.LIMIT_POSTS_ON_PAGE;
		if(endPost>allComments) {
			comments = comments.subList(startPost, allComments);
		} else {
			comments = comments.subList(startPost, endPost);
		}
		for (Comment comment : comments) {
			userService.setPathToPhotos(comment.getUser());
		}
		modelAndView.addObject(ControllerParamConstant.LIST_CATEGORY_WITH_ALL_SUBCATEGORY, guestService.getAllCategories());
		modelAndView.addObject(ControllerParamConstant.POST, post);
		modelAndView.addObject(ControllerParamConstant.LIST_COMMENTS_LIMIT_10, comments);
		modelAndView.addObject(ControllerParamConstant.START_PAGE, startPage);
		if(endPage>maxPage) {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, maxPage);
		} else {
			modelAndView.addObject(ControllerParamConstant.END_PAGE, endPage);
		}
		modelAndView.addObject(ControllerParamConstant.COUNT_LIKE, guestService.getCountLikeByPost(idPost));
		modelAndView.addObject(ControllerParamConstant.MAX_PAGE, maxPage);
		modelAndView.addObject(ControllerParamConstant.THIS_PAGE, page);
		modelAndView.addObject(ControllerParamConstant.SIZE_COMMENTS, allComments);
		modelAndView.addObject(ControllerParamConstant.COMMENT_FORM, commentForm);
		modelAndView.addObject(ControllerParamConstant.ID_POST, idPost);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView commentValid(CommentForm commentForm,
			BindingResult result) throws Exception {
		commentValidator.validate(commentForm, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("redirect:/model?id="+commentForm.getIdPost());
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("forward:/guest/addComment");
		modelAndView.addObject("commentForm", commentForm);
		return modelAndView;
	}

}
