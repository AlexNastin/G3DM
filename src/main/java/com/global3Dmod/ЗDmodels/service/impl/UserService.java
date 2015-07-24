package com.global3Dmod.«Dmodels.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.«Dmodels.dao.IPostDAO;
import com.global3Dmod.«Dmodels.dao.IUserDAO;
import com.global3Dmod.«Dmodels.domain.Post;
import com.global3Dmod.«Dmodels.domain.User;
import com.global3Dmod.«Dmodels.exception.DaoException;
import com.global3Dmod.«Dmodels.exception.ServiceException;
import com.global3Dmod.«Dmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.«Dmodels.form.DesignerPersonalSecurityForm;
import com.global3Dmod.«Dmodels.form.UserPersonalDataForm;
import com.global3Dmod.«Dmodels.form.UserPersonalSecurityForm;
import com.global3Dmod.«Dmodels.service.IUserService;
import com.global3Dmod.«Dmodels.service.ServiceParamConstant;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDesigner;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDesignerDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByRating;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByRatingDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByTitleDesc;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IPostDAO postDAO;

	@Override
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
	public List<User> getTop3Users() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectTop3Users();
		} catch (DaoException e) {
			throw new ServiceException(e);
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

	@Override
	public List<Post> getPostsByUserForSort(Integer idUser)
			throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByUserForSort(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token)
			throws ServiceException {
	}
	
	@Override
	public void updateUser(UserPersonalDataForm personalDataForm, String login)
			throws ServiceException {
		try {
			User user = userDAO.selectUser(login);
			user.setCountry_idCountry(personalDataForm.getCountry_idCountry());
			user.setCity_id—ity(personalDataForm.getCity_idCity());
			user.setName(personalDataForm.getName());
			user.setSurname(personalDataForm.getSurname());
			user.setGender(personalDataForm.getGender());
			user.setDateBirth(personalDataForm.getDateBirth());
			userDAO.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void updatePassword(UserPersonalSecurityForm personalSecurityForm,
			String login) throws ServiceException {
		try {
			User user = userDAO.selectUser(login);
			String password = personalSecurityForm.getPassword();
			if (password != null) {
				String md5Password = DigestUtils.md5Hex(password);
				user.setPassword(md5Password);
			}
			userDAO.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
