package com.global3Dmod.ÇDmodels.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.dao.IUserDAO;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.DaoException;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.service.IUserService;
import com.global3Dmod.ÇDmodels.service.ServiceParamConstant;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesigner;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesignerDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByRating;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByRatingDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitleDesc;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	public List<User> getAllUsers() throws ServiceException {
		List<User> users = null;

		try {
			users = userDAO.selectAllUsers();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return users;
	}

	@Override
	public List<User> getTop3Users() {
		List<User> users = null;
		try {
			userDAO.selectTop3Users();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException {
		if (sort != null) {
			if (ServiceParamConstant.TITLE.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByTitleDesc());
				} else {
					Collections.sort(posts, new SortedPostsByTitle());
				}	
			} else if (ServiceParamConstant.RATING.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByRatingDesc());
				} else {
					Collections.sort(posts, new SortedPostsByRating());
				}
			} else if (ServiceParamConstant.DESIGNER.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByDesignerDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDesigner());
				}
			} 
		}
		return posts;
	}
	
	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,	String sort, boolean desc) throws ServiceException {
		if(ServiceParamConstant.RATING.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.RATING_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.RATING_DESC, false);
		}
		if(ServiceParamConstant.DESIGNER.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, false);
		}
		if(ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		return modelAndView;
	}

}
