package com.global3Dmod.ÇDmodels.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global3Dmod.ÇDmodels.dao.ICategoryDAO;
import com.global3Dmod.ÇDmodels.dao.IDisProgramDAO;
import com.global3Dmod.ÇDmodels.dao.IPostDAO;
import com.global3Dmod.ÇDmodels.dao.IPrinterDAO;
import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.DisProgram;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.Printer;
import com.global3Dmod.ÇDmodels.exception.DaoException;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.SignupForm;
import com.global3Dmod.ÇDmodels.service.IDesignerService;

@Service
public class DesignerService  implements IDesignerService{
	
	private final String FORMAT_DATE = "yyyy-MM-dd";

	@Autowired
	private IDisProgramDAO disProgramDAO;
	
	@Autowired
	private ICategoryDAO categoryDAO;
	
	@Autowired
	private IPrinterDAO printerDAO;
	
	@Autowired
	private IPostDAO postDAO;
	
	@Override
	public List<DisProgram> getAllDisPrograms() throws ServiceException {
		List<DisProgram> disPrograms;
		try {
			disPrograms = disProgramDAO.selectAllDisPrograms();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return disPrograms;
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
	public List<Printer> getAllPrinters() throws ServiceException {
		List<Printer> printers;
		try {
			printers = printerDAO.selectAllPrinters();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return printers;
	}
	
	@Override
	public List<Printer> getCheckPrintersById(String[] printersId) throws ServiceException {
		List<Printer> printers;
		try {
			printers = printerDAO.selectCheckPrintersById(printersId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return printers;
	}

	@Override
	public void addPost(PostForm postForm) throws ServiceException {
		DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
		Date date = new Date();
		String registrationDate = dateFormat.format(date);
		Post post = new Post();
		post.setUser_idUser(2);
		post.setCategory_idCategory(postForm.getCategory_idCategory());
		post.setSubcategory_idSubcategory(postForm.getSubcategory_idSubcategory());
		post.setNumberPost("1111");
		post.setDisProgram_idDisProgram(postForm.getDisProgram_idDisProgram());
		post.setDateReg(registrationDate);
		post.setTitle(postForm.getTitle());
		post.setDescription(postForm.getDescription());
		post.setInstruction(postForm.getInstruction());
		post.setDisplay(true);
		post.setCountDownload(0);
		post.setPrinters(getCheckPrintersById(postForm.getPrintersId()));
		try {
			postDAO.insertPost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
	}



}
