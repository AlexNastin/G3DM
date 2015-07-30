package com.global3Dmod.ÇDmodels.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.dao.IAdvertisementDAO;
import com.global3Dmod.ÇDmodels.dao.IUserDAO;
import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.DaoException;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.AddAdvertisementForm;
import com.global3Dmod.ÇDmodels.property.PropertyManagerG3DM;
import com.global3Dmod.ÇDmodels.property.PropertyNameG3DM;
import com.global3Dmod.ÇDmodels.service.IAdminService;
import com.global3Dmod.ÇDmodels.service.IDesignerService;
import com.global3Dmod.ÇDmodels.service.ServiceParamConstant;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByClient;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByClientDesc;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByExpirationDate;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByExpirationDateDesc;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByRegistrationDate;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByRegistrationDateDesc;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByTitle;
import com.global3Dmod.ÇDmodels.sort.advertisement.SortedAdvertisementsByTitleDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesigner;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesignerDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByRating;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByRatingDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitleDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCity;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCityDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCountry;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByCountryDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByDateRegistration;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByDateRegistrationDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByLogin;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByLoginDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByName;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByNameDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByNickName;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersByNickNameDesc;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersBySurname;
import com.global3Dmod.ÇDmodels.sort.user.SortedUsersBySurnameDesc;

@Service
public class AdminService implements IAdminService{
	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IDesignerService designerServise;
	
	@Autowired
	private IAdvertisementDAO advertisementDAO;
	
	@Autowired
	private PropertyManagerG3DM propertyManagerG3DM;

	@Override
	public List<User> getModeratorsForSort() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectModeratorsForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public List<User> getDesignersForSort() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectDesignersForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public List<User> getUsersForSort() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectUsersForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}
	
	@Override
	public List<Advertisement> getAdvertisementsForSort()
			throws ServiceException {
		List<Advertisement> advertisements = null;
		try {
			advertisements = advertisementDAO.selectAllAdvertisements();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return advertisements;
	}
	
	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,	String sort, boolean desc) throws ServiceException {
		if(ServiceParamConstant.NICKNAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.NICKNAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.NICKNAME_DESC, false);
		}
		if(ServiceParamConstant.LOGIN.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.LOGIN_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.LOGIN_DESC, false);
		}
		if(ServiceParamConstant.NAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.NAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.NAME_DESC, false);
		}
		if(ServiceParamConstant.SURNAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.SURNAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.SURNAME_DESC, false);
		}
		if(ServiceParamConstant.DATE_REGISTRATION.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC, false);
		}
		if(ServiceParamConstant.COUNTRY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.COUNTRY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.COUNTRY_DESC, false);
		}
		if(ServiceParamConstant.CITY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CITY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CITY_DESC, false);
		}
		return modelAndView;
	}
	
	@Override
	public ModelAndView setParamsAdvertisementForSort(
			ModelAndView modelAndView, String sort, boolean desc)
			throws ServiceException {
		if(ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		if(ServiceParamConstant.CLIENT.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CLIENT_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CLIENT_DESC, false);
		}
		if(ServiceParamConstant.DATE_EXPIRATION.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_EXPIRATION_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_EXPIRATION_DESC, false);
		}
		if(ServiceParamConstant.DATE_REGISTRATION.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC, false);
		}
		return modelAndView;
	}
	
	@Override
	public List<User> sortUsers(List<User> users, String sort, boolean desc)
			throws ServiceException {
		if (sort != null) {
			if (ServiceParamConstant.NICKNAME.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByNickNameDesc());
				} else {
					Collections.sort(users, new SortedUsersByNickName());
				}	
			} else if (ServiceParamConstant.LOGIN.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByLoginDesc());
				} else {
					Collections.sort(users, new SortedUsersByLogin());
				}
			} else if (ServiceParamConstant.NAME.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByNameDesc());
				} else {
					Collections.sort(users, new SortedUsersByName());
				}
			} else if (ServiceParamConstant.SURNAME.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersBySurnameDesc());
				} else {
					Collections.sort(users, new SortedUsersBySurname());
				}
			} else if (ServiceParamConstant.DATE_REGISTRATION.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByDateRegistrationDesc());
				} else {
					Collections.sort(users, new SortedUsersByDateRegistration());
				}
			} else if (ServiceParamConstant.COUNTRY.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByCountryDesc());
				} else {
					Collections.sort(users, new SortedUsersByCountry());
				}
			} else if (ServiceParamConstant.CITY.equals(sort)) {
				if(desc){
					Collections.sort(users, new SortedUsersByCityDesc());
				} else {
					Collections.sort(users, new SortedUsersByCity());
				}
			} 
		}
		return users;
	}

	@Override
	public List<Advertisement> sortAdvertisements(
			List<Advertisement> advertisements, String sort, boolean desc) {
		if (sort != null) {
			if (ServiceParamConstant.TITLE.equals(sort)) {
				if(desc){
					Collections.sort(advertisements, new SortedAdvertisementsByTitleDesc());
				} else {
					Collections.sort(advertisements, new SortedAdvertisementsByTitle());
				}	
			} else if (ServiceParamConstant.CLIENT.equals(sort)) {
				if(desc){
					Collections.sort(advertisements, new SortedAdvertisementsByClientDesc());
				} else {
					Collections.sort(advertisements, new SortedAdvertisementsByClient());
				}
			} else if (ServiceParamConstant.DATE_EXPIRATION.equals(sort)) {
				if(desc){
					Collections.sort(advertisements, new SortedAdvertisementsByExpirationDateDesc());
				} else {
					Collections.sort(advertisements, new SortedAdvertisementsByExpirationDate());
				}
			} else if (ServiceParamConstant.DATE_REGISTRATION.equals(sort)) {
				if(desc){
					Collections.sort(advertisements, new SortedAdvertisementsByRegistrationDateDesc());
				} else {
					Collections.sort(advertisements, new SortedAdvertisementsByRegistrationDate());
				}
			}
		}
		return advertisements;
	}

	@Override
	public void setPathToPhotos(List<Advertisement> advertisements)
			throws ServiceException {
		for (Advertisement advertisement : advertisements) {
			String oldPath = advertisement.getFilePath();
			StringBuilder fullPath = new StringBuilder(propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE));
			fullPath.append(oldPath);
			advertisement.setFilePath(fullPath.toString());
		}
	}

	@Override
	public void addAdvertisement(AddAdvertisementForm addAdvertisementForm,
			String serverPath) throws ServiceException {
		DateFormat dateFormat = new SimpleDateFormat(
				ServiceParamConstant.FORMAT_DATE);
		Date date = new Date();
		String registrationDate = dateFormat.format(date);
		Advertisement advertisement = new Advertisement();
		advertisement.setTitle(addAdvertisementForm.getTitle());
		advertisement.setClient(addAdvertisementForm.getClient());
		advertisement.setDescription(addAdvertisementForm.getDescription());
		advertisement.setRegistrationDate(registrationDate);
		advertisement.setExpirationDate(addAdvertisementForm.getExpirationDate());
		
		String pathAdvertisement = createAdvertisementPath(addAdvertisementForm.getClient());
		String fullPathAdvertisement = serverPath.concat(pathAdvertisement);
		String newName = advertisementUpload(addAdvertisementForm.getAdvertisementPhoto(), fullPathAdvertisement);
		advertisement.setFileName(newName);
		advertisement.setFilePath(pathAdvertisement + newName);
		
		try {
			advertisementDAO.insertAdvertisement(advertisement);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
	}
	
	private String createAdvertisementPath(String client) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("advertisements/");
		stringBuilder.append(client);
		stringBuilder.append("/");
		String path = stringBuilder.toString();
		return path;
	}
	
	@Override
	public String advertisementUpload(MultipartFile file, String path)
			throws ServiceException {
		String orgName = file.getOriginalFilename();
		String newName = designerServise.createNewNameFile(orgName);
		String filePath = path + newName;
		new File(path).mkdirs();
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newName;
	}

}
