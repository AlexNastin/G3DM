package com.global3Dmod.�Dmodels.service;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.domain.Subcategory;
import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.SignupForm;

public interface IGuestService {
	
	public void addUser(SignupForm signupForm, User user) throws ServiceException;
	
	public List<String> getAllEmail() throws ServiceException;

	public List<String> getAllNickName() throws ServiceException;
	
	public List<Category> getAllCategories() throws ServiceException;
	
	public List<Subcategory> getAllSubcategories() throws ServiceException;
}
