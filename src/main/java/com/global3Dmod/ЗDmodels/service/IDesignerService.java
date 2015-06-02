package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.DisProgram;
import com.global3Dmod.ÇDmodels.domain.Post;
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

	public void addPost(PostForm postForm, int idUser, String nickName) throws ServiceException;

	public String modelFileUpload(MultipartFile file) throws ServiceException;

	public String photoModelFileUpload(MultipartFile file)
			throws ServiceException;

	public String avatarFileUpload(MultipartFile file) throws ServiceException;

	public List<Subcategory> getAllSubcategoryWithinCategory(int idCategory) throws ServiceException;
	
	public List<Post> getPostsByDesigner(Integer idUser) throws ServiceException;
	
	public List<Post> getPostsLimit10ByDesigner(Integer page, Integer idDesigner) throws ServiceException;
	
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc) throws ServiceException;

}
