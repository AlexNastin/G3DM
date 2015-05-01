package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.DisProgram;
import com.global3Dmod.ÇDmodels.domain.Printer;
import com.global3Dmod.ÇDmodels.domain.Subcategory;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.PostForm;

public interface IDesignerService {

	public List<DisProgram> getAllDisPrograms() throws ServiceException;

	public List<Category> getAllCategories() throws ServiceException;

	public List<Printer> getAllPrinters() throws ServiceException;

	public List<Printer> getCheckPrintersById(String[] printersId)
			throws ServiceException;

	public void addPost(PostForm postForm) throws ServiceException;

	public String modelFileUpload(MultipartFile file) throws ServiceException;

	public String photoModelFileUpload(MultipartFile file)
			throws ServiceException;

	public String avatarFileUpload(MultipartFile file) throws ServiceException;

	public List<Subcategory> getAllSubcategoryWithinCategory(int id)
			throws ServiceException;

}
