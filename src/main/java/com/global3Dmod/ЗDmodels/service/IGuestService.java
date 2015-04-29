package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.Subcategory;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.SignupForm;

public interface IGuestService {
	
	public void addUser(SignupForm signupForm) throws ServiceException;
	
	public List<String> getAllEmail() throws ServiceException;

	public List<String> getAllNickName() throws ServiceException;
	
	public List<Category> getAllCategories() throws ServiceException;
	
	public List<Subcategory> getAllSubcategories() throws ServiceException;
	
	public List<Subcategory> getTop3Subcategories(Integer id) throws ServiceException;
	
	public List<Category> getAllCategoriesSubcategoriesTop3() throws ServiceException;
	
	
}
