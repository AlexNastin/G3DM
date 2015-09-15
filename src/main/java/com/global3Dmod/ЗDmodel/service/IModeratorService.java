package com.global3Dmod.�Dmodel.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.�Dmodel.domain.Person;
import com.global3Dmod.�Dmodel.domain.Post;
import com.global3Dmod.�Dmodel.exception.ServiceException;
import com.global3Dmod.�Dmodel.form.RejectMessageForm;

public interface IModeratorService {

	public List<Post> getPostsByModeratingForSort() throws ServiceException;

	public List<Post> getComplainedPostsForSort() throws ServiceException;

	public List<Post> getPostsByRejectingForSort() throws ServiceException;

	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) throws ServiceException;

	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException;

	public void publishPost(Integer idPost) throws ServiceException;

	public void addRejectMessage(RejectMessageForm rejectMessageForm,
			Person person) throws ServiceException;

	public void setComplainInPosts(List<Post> posts) throws ServiceException;

	public int getCountComplainByPost(Integer idPost) throws ServiceException;

	public void removeComplainsPost(Integer idPost) throws ServiceException;
}
