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
import com.global3Dmod.ÇDmodels.service.IAdminService;
import com.global3Dmod.ÇDmodels.service.ServiceParamConstant;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesigner;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesignerDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByRating;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByRatingDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitleDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCity;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCityDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCountry;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCountryDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByDateRegistration;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByDateRegistrationDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByLogin;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByLoginDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByName;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByNameDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByNickName;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByNickNameDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersBySurname;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersBySurnameDesc;

@Service
public class AdminService implements IAdminService{
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<User> getModeratorsForSort() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectModeratorsForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public List<User> getDesignersForSort() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectDesignersForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public List<User> getUsersForSort() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectUsersForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}
	
	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,	String sort, boolean desc) throws ServiceException {
		if(ServiceParamConstant.NICKNAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.NICKNAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.NICKNAME_DESC, false);
		}
		if(ServiceParamConstant.LOGIN.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.LOGIN_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.LOGIN_DESC, false);
		}
		if(ServiceParamConstant.NAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.NAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.NAME_DESC, false);
		}
		if(ServiceParamConstant.SURNAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.SURNAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.SURNAME_DESC, false);
		}
		if(ServiceParamConstant.DATE_REGISTRATION.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC, false);
		}
		if(ServiceParamConstant.COUNTRY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.COUNTRY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.COUNTRY_DESC, false);
		}
		if(ServiceParamConstant.CITY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CITY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CITY_DESC, false);
		}
		return modelAndView;
	}
	
	@Override
	public List<User> sortUsers(List<User> users, String sort, boolean desc)
			throws ServiceException {
		if (sort != null) {
			if (ServiceParamConstant.NICKNAME.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByNickNameDesc());
				} else {
					Collections.sort(users, new SortedUsersByNickName());
				}	
			} else if (ServiceParamConstant.LOGIN.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByLoginDesc());
				} else {
					Collections.sort(users, new SortedUsersByLogin());
				}
			} else if (ServiceParamConstant.NAME.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByNameDesc());
				} else {
					Collections.sort(users, new SortedUsersByName());
				}
			} else if (ServiceParamConstant.SURNAME.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersBySurnameDesc());
				} else {
					Collections.sort(users, new SortedUsersBySurname());
				}
			} else if (ServiceParamConstant.DATE_REGISTRATION.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByDateRegistrationDesc());
				} else {
					Collections.sort(users, new SortedUsersByDateRegistration());
				}
			} else if (ServiceParamConstant.COUNTRY.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByCountryDesc());
				} else {
					Collections.sort(users, new SortedUsersByCountry());
				}
			} else if (ServiceParamConstant.CITY.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByCityDesc());
				} else {
					Collections.sort(users, new SortedUsersByCity());
				}
			} 
		}
		return users;
	}

}
