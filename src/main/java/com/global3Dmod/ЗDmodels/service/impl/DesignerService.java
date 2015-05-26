package com.global3Dmod.«Dmodels.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.global3Dmod.«Dmodels.dao.ICategoryDAO;
import com.global3Dmod.«Dmodels.dao.IDisProgramDAO;
import com.global3Dmod.«Dmodels.dao.IPostDAO;
import com.global3Dmod.«Dmodels.dao.IPrinterDAO;
import com.global3Dmod.«Dmodels.domain.Category;
import com.global3Dmod.«Dmodels.domain.DisProgram;
import com.global3Dmod.«Dmodels.domain.Post;
import com.global3Dmod.«Dmodels.domain.PostPhoto;
import com.global3Dmod.«Dmodels.domain.Printer;
import com.global3Dmod.«Dmodels.domain.Subcategory;
import com.global3Dmod.«Dmodels.exception.DaoException;
import com.global3Dmod.«Dmodels.exception.ServiceException;
import com.global3Dmod.«Dmodels.form.PostForm;
import com.global3Dmod.«Dmodels.service.IDesignerService;
import com.global3Dmod.«Dmodels.service.ServiceParamConstant;
import com.global3Dmod.«Dmodels.service.helper.ServiceHelper;

@Service
public class DesignerService implements IDesignerService {

	private final String MODEL_PATH = "D:/";
	private final String PHOTO_MODEL_PATH = "D:/";
	private final String AVATAR_PATH = "D:/";

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
			for (int i = 0; i < categories.size(); i++) {
				categories.get(i).setSubcategories(null);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return categories;
	}

	@Override
	public List<Subcategory> getAllSubcategoryWithinCategory(int idCategory)
			throws ServiceException {
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
//		List<Category> categories;
		Category category1;
		try {
			category1 = categoryDAO.selectCategoryById(idCategory);
			subcategories = category1.getSubcategories();
			for (Subcategory subcategory : subcategories) {
				subcategory.setCategory(null);
			}
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//			try {
//			categories = categoryDAO.selectAllCategories();
//			for (Category category : categories) {
//				if (category.getIdCategory() == idCategory) {
//					List<Subcategory> subcategories2 = category
//							.getSubcategories();
//					for (Subcategory subcategory : subcategories2) {
//						subcategory.setCategory(null);
//
//					}
//					subcategories.addAll(subcategories2);
//				}
//			}
//		} catch (DaoException e) {
//			throw new ServiceException(e);
//		}
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
	public void addPost(PostForm postForm, int idUser, String nickName) throws ServiceException {
		// postForm.setModelFilePath(modelFileUpload(postForm.getModel())); // ÕËÍËÚ‡  ˝ÚÓÚ ÚÂ·Â Ì‡‰Ó? ÂÒÎË ÌÂÚ ÚÓ ‰ÂÎÂÚÂ‰.
		DateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.FORMAT_DATE);
		Date date = new Date();
		
		String registrationDate = dateFormat.format(date);
		Post post = new Post();
		post.setUser_idUser(idUser);
		post.setCategory_idCategory(postForm.getCategory_idCategory());
		post.setSubcategory_idSubcategory(postForm
				.getSubcategory_idSubcategory());
		post.setNumberPost(ServiceHelper.generationNumberPost(date, nickName));
		post.setDisProgram_idDisProgram(postForm.getDisProgram_idDisProgram());
		post.setDateReg(registrationDate);
		post.setDateUpdate(registrationDate);
		post.setTitle(postForm.getTitle());
		post.setDescription(postForm.getDescription());
		post.setInstruction(postForm.getInstruction());
		post.setIsDisplay(ServiceParamConstant.DEFAULT_IS_DISPLAY);
		post.setCountDownload(ServiceParamConstant.DEFAULT_COUNT);
		post.setPrinters(getCheckPrintersById(postForm.getPrintersId()));
		
		PostPhoto firstPostPhoto = new PostPhoto();
		firstPostPhoto.setPhotoPath(photoModelFileUpload(postForm
				.getFirstPhoto()));
		firstPostPhoto.setPost(post);
		
		PostPhoto secondPostPhoto = new PostPhoto();
		secondPostPhoto.setPhotoPath(photoModelFileUpload(postForm
				.getSecondPhoto()));
		secondPostPhoto.setPost(post);
		
		PostPhoto thirdPostPhoto = new PostPhoto();
		thirdPostPhoto.setPhotoPath(photoModelFileUpload(postForm
				.getThirdPhoto()));
		thirdPostPhoto.setPost(post);
		
		List<PostPhoto> postPhotos = new ArrayList<PostPhoto>();
		postPhotos.add(firstPostPhoto);
		postPhotos.add(secondPostPhoto);
		postPhotos.add(thirdPostPhoto);
		post.setPostPhotos(postPhotos);

		com.global3Dmod.«Dmodels.domain.File file = new com.global3Dmod.«Dmodels.domain.File();
		file.setFilePath(modelFileUpload(postForm.getModel()));
		file.setPost(post);
		post.setFile(file);
		
		try {
			postDAO.insertPost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public String modelFileUpload(MultipartFile file) throws ServiceException {
		String filePlaceToUpload = MODEL_PATH;
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
		String filePlaceToUpload = PHOTO_MODEL_PATH;
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
		String filePlaceToUpload = AVATAR_PATH;
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
	public List<Post> getPostsByDesigner(Integer idUser) throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByDesigner(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@Override
	public List<Post> getPostsLimit10ByDesigner(Integer page, Integer idDesigner)
			throws ServiceException {
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.selectPostsLimit10ByDesigner(page, idDesigner);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

}
