package com.global3Dmod.�Dmodels.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.global3Dmod.�Dmodels.dao.ICategoryDAO;
import com.global3Dmod.�Dmodels.dao.IDisProgramDAO;
import com.global3Dmod.�Dmodels.dao.IPostDAO;
import com.global3Dmod.�Dmodels.dao.IPrinterDAO;
import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.domain.DisProgram;
import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.Printer;
import com.global3Dmod.�Dmodels.domain.Subcategory;
import com.global3Dmod.�Dmodels.exception.DaoException;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.PostForm;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.service.IDesignerService;

@Service
public class DesignerService implements IDesignerService {

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
	public List<Subcategory> getAllSubcategoryWithinCategory(int id)
			throws ServiceException {
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
		List<Category> categories;
		try {
			categories = categoryDAO.selectAllCategories();
			for (Category category : categories) {
				if (category.getIdCategory() == id) {
					List<Subcategory> subcategories2 = category
							.getSubcategories();
					for (Subcategory subcategory : subcategories2) {
						subcategory.setCategory(null);

					}
					subcategories.addAll(subcategories2);
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return subcategories;
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
	public List<Printer> getCheckPrintersById(String[] printersId)
			throws ServiceException {
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
		post.setSubcategory_idSubcategory(postForm
				.getSubcategory_idSubcategory());
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

	@Override
	public String modelFileUpload(MultipartFile file) throws ServiceException {
		String filePlaceToUpload = "C:/Users/User/git/G3DM/src/main/webapp/resources/files/models/";
		String orgName = file.getOriginalFilename();
		String filePath = filePlaceToUpload + orgName;
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}

	@Override
	public String photoModelFileUpload(MultipartFile file)
			throws ServiceException {
		String filePlaceToUpload = "C:/Users/User/git/G3DM/src/main/webapp/resources/files/photosModel/";
		String orgName = file.getOriginalFilename();
		String filePath = filePlaceToUpload + orgName;
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}

	@Override
	public String avatarFileUpload(MultipartFile file) throws ServiceException {
		String filePlaceToUpload = "C:/Users/User/git/G3DM/src/main/webapp/resources/files/avatars/";
		String orgName = file.getOriginalFilename();
		String filePath = filePlaceToUpload + orgName;
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}

}
