package com.global3Dmod.�Dmodels.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.ServiceException;

public interface IUserService {

	public List<User> getAllUsers() throws ServiceException;

	public List<User> getTop3Users() throws ServiceException;
	
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc) throws ServiceException;
	
	public ModelAndView setParamsForSort(ModelAndView modelAndView, String sort, boolean desc) throws ServiceException;
}
