package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalSecurityForm;
import com.global3Dmod.ÇDmodels.form.UserPersonalDataForm;
import com.global3Dmod.ÇDmodels.form.UserPersonalSecurityForm;

public interface IUserService {

	public List<User> getAllUsers() throws ServiceException;

	public List<User> getTop3Users() throws ServiceException;

	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException;

	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) throws ServiceException;

	public List<Post> getPostsByUserForSort(Integer idUser)
			throws ServiceException;

	
	public void updateUser(UserPersonalDataForm personalDataForm, String login)
			throws ServiceException;

	public void updatePassword(UserPersonalSecurityForm personalSecurityForm,
			String login) throws ServiceException;

}
