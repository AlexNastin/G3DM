package com.global3Dmod.ÇDmodels.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.aop.annotation.AspectLogG3DM;
import com.global3Dmod.ÇDmodels.dao.IComplainDAO;
import com.global3Dmod.ÇDmodels.dao.IPostDAO;
import com.global3Dmod.ÇDmodels.dao.IRejectMessageDAO;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.RejectMessage;
import com.global3Dmod.ÇDmodels.exception.DaoException;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.RejectMessageForm;
import com.global3Dmod.ÇDmodels.service.IModeratorService;
import com.global3Dmod.ÇDmodels.service.ServiceParamConstant;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByCategory;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByCategoryDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByComplain;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByComplainDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDate;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDateDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesigner;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesignerDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsBySubcategory;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsBySubcategoryDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitleDesc;

@Service
public class ModeratorService implements IModeratorService {

	@Autowired
	private IPostDAO postDAO;

	@Autowired
	private IComplainDAO complainDAO;

	@Autowired
	private IRejectMessageDAO rejectMessageDAO;

	@AspectLogG3DM
	@Override
	public List<Post> getPostsByModeratingForSort() throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByModeratingForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public List<Post> getPostsByRejectingForSort() throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByRejectingForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) {
		if (ServiceParamConstant.CATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, false);
		}
		if (ServiceParamConstant.DATE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, false);
		}
		if (ServiceParamConstant.DESIGNER.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, false);
		}
		if (ServiceParamConstant.SUBCATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.SUBCATEGORY_DESC, true);
		} else {
			modelAndView
					.addObject(ServiceParamConstant.SUBCATEGORY_DESC, false);
		}
		if (ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		if (ServiceParamConstant.COMPLAIN.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.COMPLAIN_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.COMPLAIN_DESC, false);
		}
		return modelAndView;
	}

	@Override
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc) {
		if (sort != null) {
			if (ServiceParamConstant.TITLE.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByTitleDesc());
				} else {
					Collections.sort(posts, new SortedPostsByTitle());
				}
			} else if (ServiceParamConstant.CATEGORY.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByCategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsByCategory());
				}
			} else if (ServiceParamConstant.SUBCATEGORY.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsBySubcategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsBySubcategory());
				}
			} else if (ServiceParamConstant.DATE.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByDateDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDate());
				}
			} else if (ServiceParamConstant.DESIGNER.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByDesignerDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDesigner());
				}
			} else if (ServiceParamConstant.COMPLAIN.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByComplainDesc());
				} else {
					Collections.sort(posts, new SortedPostsByComplain());
				}
			}
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public void publishPost(Integer idPost) throws ServiceException {
		Post post = null;
		try {
			post = postDAO.selectPostWithoutAll(idPost);
			post.setIsDisplay(3);
			postDAO.updatePost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
	@Override
	public void addRejectMessage(RejectMessageForm rejectMessageForm,
			Person person) throws ServiceException {
		RejectMessage rejectMessage;
		try {
			rejectMessage = rejectMessageDAO
					.selectRejectMessageByPost(rejectMessageForm.getIdPost());
			if (rejectMessage == null) {
				rejectMessage = new RejectMessage();
				rejectMessage.setPost(postDAO
						.selectPostWithoutAll(rejectMessageForm.getIdPost()));
				rejectMessage.setUser_idUser(person.getIdPerson());
				rejectMessage.setMessage(rejectMessageForm.getText());
				rejectMessageDAO.insertRejectMessage(rejectMessage);
			} else {
				rejectMessage.setUser_idUser(person.getIdPerson());
				rejectMessage.setMessage(rejectMessageForm.getText());
				rejectMessageDAO.updateRejectMessage(rejectMessage);
			}
			Post post = postDAO.selectPostWithoutAll(rejectMessageForm
					.getIdPost());
			post.setIsDisplay(1);
			post.setComplain(0);
			postDAO.updatePost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
	@Override
	public List<Post> getComplainedPostsForSort() throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectComplainedPostsForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public void setComplainInPosts(List<Post> posts) throws ServiceException {
		for (Post post : posts) {
			post.setComplain(getCountComplainByPost(post.getIdPost()));
		}
	}

	@AspectLogG3DM
	@Override
	public int getCountComplainByPost(Integer idPost) throws ServiceException {
		int count;
		try {
			count = complainDAO.selectCountComplainByPost(idPost);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return count;
	}

	@AspectLogG3DM
	@Override
	public void removeComplainsPost(Integer idPost) throws ServiceException {
		try {
			complainDAO.deleteComplains(idPost);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
