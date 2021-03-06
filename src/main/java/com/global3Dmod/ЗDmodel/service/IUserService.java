package com.global3Dmod.�Dmodel.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodel.domain.Post;
import com.global3Dmod.�Dmodel.domain.User;
import com.global3Dmod.�Dmodel.exception.ServiceException;
import com.global3Dmod.�Dmodel.form.UserPersonalDataForm;
import com.global3Dmod.�Dmodel.form.UserPersonalSecurityForm;

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
