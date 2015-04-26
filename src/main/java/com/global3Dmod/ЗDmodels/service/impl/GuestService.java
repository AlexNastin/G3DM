package com.global3Dmod.�Dmodels.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global3Dmod.�Dmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.�Dmodels.dao.ICategoryDAO;
import com.global3Dmod.�Dmodels.dao.ISubcategoryDAO;
import com.global3Dmod.�Dmodels.dao.IUserDAO;
import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.domain.Subcategory;
import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.DaoException;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.service.IGuestService;
import com.global3Dmod.�Dmodels.service.ParamConstant;

@Service
public class GuestService implements IGuestService {

	private final String FORMAT_DATE = "yyyy-MM-dd";

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private ICategoryDAO categoryDAO;
	
	@Autowired
	private ISubcategoryDAO subcategoryDAO;


	@Override
	public void addUser(SignupForm signupForm, User user)
			throws ServiceException {

		DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
		Date date = new Date();
		String registrationDate = dateFormat.format(date);

		String md5Password = DigestUtils.md5Hex(signupForm.getPassword());

		user.setRole_idRole(signupForm.getRole_idRole());
		user.setCountry_id�ountry(ParamConstant.ID_�OUNTRY);
		user.setCity_id�ity(ParamConstant.ID_�ITY);
		user.setNickName(signupForm.getNickName());
		user.setLogin(signupForm.getLogin());
		user.setPassword(md5Password);
		user.setName(ParamConstant.EMPTY);
		user.setSurname(ParamConstant.EMPTY);
		user.setGender(ParamConstant.GENDER);
		user.setRegistrationDate(registrationDate);

		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<String> getAllEmail() throws ServiceException {
		List<String> emails;
		try {
			emails = userDAO.selectAllEmail();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return emails;
	}

	@Override
	public List<String> getAllNickName() throws ServiceException {
		List<String> nickNames;
		try {
			nickNames = userDAO.selectAllNickName();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return nickNames;
	}

	@Override
	public List<Category> getAllCategories() throws ServiceException {
		List<Category> categories;
		try {
			categories = categoryDAO.selectAllCategories();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return categories;
	}

	@Override
	public List<Subcategory> getAllSubcategories() throws ServiceException {
		List<Subcategory> subcategories;
		try {
			subcategories = subcategoryDAO.selectAllSubcategories();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return subcategories;
	}

	@Override
	public List<Subcategory> getTop3Subcategories(Integer id) throws ServiceException {
		List<Subcategory> subcategoriesTop;
		try {
			subcategoriesTop = subcategoryDAO.selectTop3Subcategories(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return subcategoriesTop;
	}

	@Override
	public List<Category> getAllCategoriesSubcategoriesTop3()
			throws ServiceException {
		List<Category> categories = getAllCategories();
		for (Category category : categories) {
			category.setSubcategories(getTop3Subcategories(category.getIdCategory()));
		}
		return categories;
	}

}
