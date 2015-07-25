package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.ServiceException;

public interface IModeratorService {
	
	public List<Post> getPostsByModeratingForSort() throws ServiceException;
	
	public List<Post> getPostsByRejectingForSort() throws ServiceException;
	
	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) throws ServiceException;
	
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException;

}
