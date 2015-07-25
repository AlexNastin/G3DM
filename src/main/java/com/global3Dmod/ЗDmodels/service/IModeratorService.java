package com.global3Dmod.�Dmodels.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.exception.ServiceException;

public interface IModeratorService {
	
	public List<Post> getPostsByModeratingForSort() throws ServiceException;
	
	public List<Post> getPostsByRejectingForSort() throws ServiceException;
	
	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) throws ServiceException;
	
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException;

}
