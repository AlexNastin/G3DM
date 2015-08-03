package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.City;
import com.global3Dmod.ÇDmodels.domain.Country;
import com.global3Dmod.ÇDmodels.domain.DisProgram;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.Technology;
import com.global3Dmod.ÇDmodels.domain.Subcategory;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.ÇDmodels.form.DesignerPersonalSecurityForm;
import com.global3Dmod.ÇDmodels.form.PostForm;
import com.global3Dmod.ÇDmodels.form.UpdatePostForm;

public interface IDesignerService {

	public List<DisProgram> getAllDisPrograms() throws ServiceException;

	public List<Category> getAllCategories() throws ServiceException;

	public List<Country> getAllCountries() throws ServiceException;

	public List<Technology> getAllTechnologies() throws ServiceException;

	public List<Technology> getCheckPrintersById(String[] printersId)
			throws ServiceException;

	public void addPost(PostForm postForm, int idUser, String nickName, String serverPath)
			throws ServiceException;

	public String modelFileUpload(MultipartFile file, String path)
			throws ServiceException;
	
	public String modelFileUpload(MultipartFile file, String path, String oldFileName)
			throws ServiceException;

	public String photoModelFileUpload(MultipartFile file, String path)
			throws ServiceException;
	
	public String photoModelFileUpload(MultipartFile file, String path, String oldFileName)
			throws ServiceException;

	public String avatarFileUpload(MultipartFile file, String path)
			throws ServiceException;
	
	public String avatarFileUpload(MultipartFile file, String path, String oldFileName)
			throws ServiceException;

	public List<Subcategory> getAllSubcategoryWithinCategory(int idCategory)
			throws ServiceException;

	public List<City> getAllCityWithinCountry(int idCountry)
			throws ServiceException;

	public List<Post> getPostsByDesigner(Integer idUser)
			throws ServiceException;

	public List<Post> getPostsByDesignerForSort(Integer idUser)
			throws ServiceException;

	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException;
	
	public List<Country> sortCountries(List<Country> countries)
			throws ServiceException;

	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) throws ServiceException;

	public User getUser(String login) throws ServiceException;

	public void updateUser(DesignerPersonalDataForm personalDataForm, String login, String serverPath)
			throws ServiceException;

	public void updatePassword(DesignerPersonalSecurityForm personalSecurityForm,
			String login) throws ServiceException;

	public void updatePost(UpdatePostForm updatePostForm, Integer idPost, String serverPath)
			throws ServiceException;

	public void deletePost(Integer idPost) throws ServiceException;

	public Post getPost(Integer idPost) throws ServiceException;
	
	public String createAvatarPath(int idUser) throws ServiceException;
	
	public String createNewNameFile(String name) throws ServiceException;

}
