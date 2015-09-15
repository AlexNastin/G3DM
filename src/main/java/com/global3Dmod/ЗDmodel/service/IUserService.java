package com.global3Dmod.ÇDmodel.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodel.domain.Post;
import com.global3Dmod.ÇDmodel.domain.User;
import com.global3Dmod.ÇDmodel.exception.ServiceException;
import com.global3Dmod.ÇDmodel.form.UserPersonalDataForm;
import com.global3Dmod.ÇDmodel.form.UserPersonalSecurityForm;

public interface IUserService {

	public List<User> getAllUsers() throws ServiceException;

	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException;

	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) throws ServiceException;

	public List<Post> getPostsByUserForSort(Integer idUser)
			throws ServiceException;

	
	public void updateUser(UserPersonalDataForm personalDataForm, String login, String serverPath)
			throws ServiceException;

	public void updatePassword(UserPersonalSecurityForm personalSecurityForm,
			String login) throws ServiceException;
	
	public void setPathToPhotos(List<Post> posts) throws ServiceException;
	
	public void setPathToPhotos(Post post) throws ServiceException;
	
	public void setPathToPhotos(User user) throws ServiceException;
	
	public void setPathToPhotosUsers(List<User> users) throws ServiceException;

}
