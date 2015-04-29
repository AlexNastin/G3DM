package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.DisProgram;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.PostForm;

public interface IDesignerService {
	
	public List<DisProgram> getAllDisPrograms() throws ServiceException;
	
	public List<Category> getAllCategories() throws ServiceException;
	
	public void addPost(PostForm postForm) throws ServiceException;

}
