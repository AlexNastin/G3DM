package com.global3Dmod.«Dmodels.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByCategory;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByCategoryDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDate;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDateDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDownloads;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDownloadsDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByStatus;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByStatusDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsBySubcategory;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsBySubcategoryDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByTitleDesc;

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
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		System.out.println(gregorianCalendar.getTime());
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
	public List<Post> getPostsByDesignerForSort(Integer idUser) throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByDesignerForSort(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@Override
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException {
		if (sort != null) {
			if (ServiceParamConstant.TITLE.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByTitleDesc());
				} else {
					Collections.sort(posts, new SortedPostsByTitle());
				}	
			} else if (ServiceParamConstant.CATEGORY.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByCategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsByCategory());
				}	
			} else if (ServiceParamConstant.SUBCATEGORY.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsBySubcategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsBySubcategory());
				}
			} else if (ServiceParamConstant.DATE.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByDateDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDate());
				}
			} else if (ServiceParamConstant.DOWNLOADS.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByDownloadsDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDownloads());
				}
			} else if (ServiceParamConstant.STATUS.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByStatusDesc());
				} else {
					Collections.sort(posts, new SortedPostsByStatus());
				}
			}
		}
		return posts;
	}

	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,	String sort, boolean desc) throws ServiceException {
		if(ServiceParamConstant.CATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, false);
		}
		if(ServiceParamConstant.DATE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, false);
		}
		if(ServiceParamConstant.DOWNLOADS.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DOWNLOADS_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DOWNLOADS_DESC, false);
		}
		if(ServiceParamConstant.STATUS.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.STATUS_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.STATUS_DESC, false);
		} 
		if (ServiceParamConstant.SUBCATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.SUBCATEGORY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.SUBCATEGORY_DESC, false);
		}
		if(ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		return modelAndView;
	}


}
