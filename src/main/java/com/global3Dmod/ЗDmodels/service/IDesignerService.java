package com.global3Dmod.�Dmodels.service;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.domain.DisProgram;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.PostForm;

public interface IDesignerService {
	
	public List<DisProgram> getAllDisPrograms() throws ServiceException;
	
	public List<Category> getAllCategories() throws ServiceException;
	
	public void addPost(PostForm postForm) throws ServiceException;

}
