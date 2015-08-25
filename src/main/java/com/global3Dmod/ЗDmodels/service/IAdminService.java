package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.AddAdvertisementForm;
import com.global3Dmod.ÇDmodels.form.UpdateAdvertisementForm;

public interface IAdminService {
	
	public List<User> getModeratorsForSort() throws ServiceException;
	
	public List<User> getDesignersForSort() throws ServiceException;
	
	public List<User> getUsersForSort() throws ServiceException;
	
	public List<Advertisement> getAdvertisementsForSort() throws ServiceException;

	public ModelAndView setParamsForSort(ModelAndView modelAndView,	String sort, boolean desc) throws ServiceException;
	
	public ModelAndView setParamsAdvertisementForSort(ModelAndView modelAndView, String sort, boolean desc) throws ServiceException;

	public List<User> sortUsers(List<User> users, String sort, boolean desc) throws ServiceException;

	public List<Advertisement> sortAdvertisements(List<Advertisement> advertisements, String sort, boolean desc);
	
	public void setPathToPhotos(List<Advertisement> advertisements) throws ServiceException;
	
	public void setPathToPhotos(Advertisement advertisement) throws ServiceException;

	public void addAdvertisement(AddAdvertisementForm addAdvertisementForm, String serverPath) throws ServiceException;
	
	public void addDefaultAdvertisement() throws ServiceException;
	
	public String advertisementUpload(MultipartFile file, String path) throws ServiceException;
	
	public Advertisement getAdvertisement(Integer idAdvertisement) throws ServiceException;

	public void updateAdvertisement(UpdateAdvertisementForm updateAdvertisementForm, String serverPath) throws ServiceException;

	public void deleteAdvertisement(Integer idAdvertisement) throws ServiceException;
	
	public void deleteModerator(Integer idUser) throws ServiceException;
	
	public void formTopDesigners() throws ServiceException;

	public int getNumberOfAllUsers() throws ServiceException;

	public int getNumberOfDesigners() throws ServiceException;

	public int getNumberOfModerators() throws ServiceException;

	public int getNumberOfUsers() throws ServiceException;

	public int getNumberOfAllPosts() throws ServiceException;

	public int getNumberOfDeletedPosts() throws ServiceException;

	public int getNumberOfRejectedPosts() throws ServiceException;

	public int getNumberOfModeratingPosts() throws ServiceException;

	public int getNumberOfPublishingPosts() throws ServiceException;

	public int getNumberOfAdmins() throws ServiceException;

}
