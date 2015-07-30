package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;

public interface IAdminService {
	
	public List<User> getModeratorsForSort() throws ServiceException;
	
	public List<User> getDesignersForSort() throws ServiceException;
	
	public List<User> getUsersForSort() throws ServiceException;
	
	public List<Advertisement> getAdvertisementsForSort() throws ServiceException;

	public ModelAndView setParamsForSort(ModelAndView modelAndView,	String sort, boolean desc) throws ServiceException;
	
	public ModelAndView setParamsAdvertisementForSort(ModelAndView modelAndView, String sort, boolean desc) throws ServiceException;

	public List<User> sortUsers(List<User> users, String sort, boolean desc) throws ServiceException;

	public List<Advertisement> sortAdvertisements(List<Advertisement> advertisements, String sort, boolean desc);
	
	public void setPathToPhotos(List<Advertisement> advertisements) throws ServiceException;

}
