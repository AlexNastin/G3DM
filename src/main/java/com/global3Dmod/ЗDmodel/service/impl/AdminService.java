package com.global3Dmod.ÇDmodel.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodel.aop.annotation.AspectLogG3DM;
import com.global3Dmod.ÇDmodel.dao.IAdvertisementDAO;
import com.global3Dmod.ÇDmodel.dao.ILikeDAO;
import com.global3Dmod.ÇDmodel.dao.IPostDAO;
import com.global3Dmod.ÇDmodel.dao.IUserDAO;
import com.global3Dmod.ÇDmodel.domain.Advertisement;
import com.global3Dmod.ÇDmodel.domain.User;
import com.global3Dmod.ÇDmodel.exception.DaoException;
import com.global3Dmod.ÇDmodel.exception.ServiceException;
import com.global3Dmod.ÇDmodel.form.AddAdvertisementForm;
import com.global3Dmod.ÇDmodel.form.UpdateAdvertisementForm;
import com.global3Dmod.ÇDmodel.property.PropertyManagerG3DM;
import com.global3Dmod.ÇDmodel.property.PropertyNameG3DM;
import com.global3Dmod.ÇDmodel.service.IAdminService;
import com.global3Dmod.ÇDmodel.service.IDesignerService;
import com.global3Dmod.ÇDmodel.service.ServiceParamConstant;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByClient;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByClientDesc;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByExpirationDate;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByExpirationDateDesc;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByRegistrationDate;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByRegistrationDateDesc;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByTitle;
import com.global3Dmod.ÇDmodel.sort.advertisement.SortedAdvertisementsByTitleDesc;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByCity;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByCityDesc;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByCountry;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByCountryDesc;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByDateRegistration;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByDateRegistrationDesc;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByLogin;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByLoginDesc;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByName;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByNameDesc;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByNickName;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersByNickNameDesc;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersBySurname;
import com.global3Dmod.ÇDmodel.sort.user.SortedUsersBySurnameDesc;

@Service
public class AdminService implements IAdminService {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private ILikeDAO likeDAO;

	@Autowired
	private IPostDAO postDAO;

	@Autowired
	private IDesignerService designerServise;

	@Autowired
	private IAdvertisementDAO advertisementDAO;

	@Autowired
	private PropertyManagerG3DM propertyManagerG3DM;

	@AspectLogG3DM
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

	@AspectLogG3DM
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

	@AspectLogG3DM
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

	@AspectLogG3DM
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
	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) {
		if (ServiceParamConstant.NICKNAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.NICKNAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.NICKNAME_DESC, false);
		}
		if (ServiceParamConstant.LOGIN.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.LOGIN_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.LOGIN_DESC, false);
		}
		if (ServiceParamConstant.NAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.NAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.NAME_DESC, false);
		}
		if (ServiceParamConstant.SURNAME.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.SURNAME_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.SURNAME_DESC, false);
		}
		if (ServiceParamConstant.DATE_REGISTRATION.equalsIgnoreCase(sort)
				&& !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC,
					true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC,
					false);
		}
		if (ServiceParamConstant.COUNTRY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.COUNTRY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.COUNTRY_DESC, false);
		}
		if (ServiceParamConstant.CITY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CITY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CITY_DESC, false);
		}
		return modelAndView;
	}

	@Override
	public ModelAndView setParamsAdvertisementForSort(
			ModelAndView modelAndView, String sort, boolean desc) {
		if (ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		if (ServiceParamConstant.CLIENT.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CLIENT_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CLIENT_DESC, false);
		}
		if (ServiceParamConstant.DATE_EXPIRATION.equalsIgnoreCase(sort)
				&& !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_EXPIRATION_DESC,
					true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_EXPIRATION_DESC,
					false);
		}
		if (ServiceParamConstant.DATE_REGISTRATION.equalsIgnoreCase(sort)
				&& !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC,
					true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_REGISTRATION_DESC,
					false);
		}
		return modelAndView;
	}

	@Override
	public List<User> sortUsers(List<User> users, String sort, boolean desc) {
		if (sort != null) {
			if (ServiceParamConstant.NICKNAME.equals(sort)) {
				if (desc) {
					Collections.sort(users, new SortedUsersByNickNameDesc());
				} else {
					Collections.sort(users, new SortedUsersByNickName());
				}
			} else if (ServiceParamConstant.LOGIN.equals(sort)) {
				if (desc) {
					Collections.sort(users, new SortedUsersByLoginDesc());
				} else {
					Collections.sort(users, new SortedUsersByLogin());
				}
			} else if (ServiceParamConstant.NAME.equals(sort)) {
				if (desc) {
					Collections.sort(users, new SortedUsersByNameDesc());
				} else {
					Collections.sort(users, new SortedUsersByName());
				}
			} else if (ServiceParamConstant.SURNAME.equals(sort)) {
				if (desc) {
					Collections.sort(users, new SortedUsersBySurnameDesc());
				} else {
					Collections.sort(users, new SortedUsersBySurname());
				}
			} else if (ServiceParamConstant.DATE_REGISTRATION.equals(sort)) {
				if (desc) {
					Collections.sort(users,
							new SortedUsersByDateRegistrationDesc());
				} else {
					Collections
							.sort(users, new SortedUsersByDateRegistration());
				}
			} else if (ServiceParamConstant.COUNTRY.equals(sort)) {
				if (desc) {
					Collections.sort(users, new SortedUsersByCountryDesc());
				} else {
					Collections.sort(users, new SortedUsersByCountry());
				}
			} else if (ServiceParamConstant.CITY.equals(sort)) {
				if (desc) {
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
				if (desc) {
					Collections.sort(advertisements,
							new SortedAdvertisementsByTitleDesc());
				} else {
					Collections.sort(advertisements,
							new SortedAdvertisementsByTitle());
				}
			} else if (ServiceParamConstant.CLIENT.equals(sort)) {
				if (desc) {
					Collections.sort(advertisements,
							new SortedAdvertisementsByClientDesc());
				} else {
					Collections.sort(advertisements,
							new SortedAdvertisementsByClient());
				}
			} else if (ServiceParamConstant.DATE_EXPIRATION.equals(sort)) {
				if (desc) {
					Collections.sort(advertisements,
							new SortedAdvertisementsByExpirationDateDesc());
				} else {
					Collections.sort(advertisements,
							new SortedAdvertisementsByExpirationDate());
				}
			} else if (ServiceParamConstant.DATE_REGISTRATION.equals(sort)) {
				if (desc) {
					Collections.sort(advertisements,
							new SortedAdvertisementsByRegistrationDateDesc());
				} else {
					Collections.sort(advertisements,
							new SortedAdvertisementsByRegistrationDate());
				}
			}
		}
		return advertisements;
	}

	@Override
	public void setPathToPhotos(List<Advertisement> advertisements) {
		// for (Advertisement advertisement : advertisements) {
		// String oldPath = advertisement.getFilePath();
		// StringBuilder fullPath = new StringBuilder(
		// propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE));
		// fullPath.append(oldPath);
		// advertisement.setFilePath(fullPath.toString());
		// }
	}

	@Override
	public void setPathToPhotos(Advertisement advertisement) {
		// String oldPath = advertisement.getFilePath();
		// StringBuilder fullPath = new StringBuilder(
		// propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE));
		// fullPath.append(oldPath);
		// advertisement.setFilePath(fullPath.toString());
	}

	@AspectLogG3DM
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
		advertisement.setExpirationDate(addAdvertisementForm
				.getExpirationDate());

		String pathAdvertisement = createAdvertisementPath(addAdvertisementForm
				.getClient());
		String fullPathAdvertisement = serverPath.concat(pathAdvertisement);
		String newName = advertisementUpload(
				addAdvertisementForm.getAdvertisementPhoto(),
				fullPathAdvertisement);
		advertisement.setFileName(newName);
		advertisement.setFilePath(pathAdvertisement + newName);

		try {
			advertisementDAO.insertAdvertisement(advertisement);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
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
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
		return newName;
	}

	@AspectLogG3DM
	@Override
	public Advertisement getAdvertisement(Integer idAdvertisement)
			throws ServiceException {
		Advertisement advertisement = null;
		try {
			advertisement = advertisementDAO
					.selectAdvertisement(idAdvertisement);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return advertisement;
	}

	@AspectLogG3DM
	@Override
	public void updateAdvertisement(
			UpdateAdvertisementForm updateAdvertisementForm, String serverPath)
			throws ServiceException {
		try {
			Advertisement advertisement = advertisementDAO
					.selectAdvertisement(updateAdvertisementForm
							.getIdAdvertisement());
			advertisement.setTitle(updateAdvertisementForm.getTitle());
			advertisement.setDescription(updateAdvertisementForm
					.getDescription());
			advertisement.setExpirationDate(updateAdvertisementForm
					.getExpirationDate());

			String pathAdvertisement = createAdvertisementPath(advertisement
					.getClient());
			String fullPathAdvertisement = serverPath.concat(pathAdvertisement);
			advertisement
					.setFilePath(pathAdvertisement
							+ advertisementUpload(updateAdvertisementForm
									.getAdvertisementPhoto(),
									fullPathAdvertisement, advertisement
											.getFileName()));
			advertisementDAO.updateAdvertisement(advertisement);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	private String advertisementUpload(MultipartFile file, String path,
			String oldFileName) throws ServiceException {
		String filePath = path + oldFileName;
		new File(path).mkdirs();
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
		return oldFileName;
	}

	private String createAdvertisementPath(String client) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("/resources/files/");
		stringBuilder.append("partner_news/");
		stringBuilder.append(client);
		stringBuilder.append("/");
		String path = stringBuilder.toString();
		return path;
	}

	@AspectLogG3DM
	@Override
	public void deleteAdvertisement(Integer idAdvertisement)
			throws ServiceException {
		try {
			advertisementDAO.deleteAdvertisement(idAdvertisement);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public void deleteModerator(Integer idUser) throws ServiceException {
		try {
			userDAO.deleteUser(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public void formTopDesigners() throws ServiceException {
		try {
			Map<Integer, Integer> colPostsWithIdDesigners = postDAO
					.selectColPostsForAllUsers();
			List<Integer> idDesigners = postDAO.selectIdDesignersHavePosts();
			for (Integer key : idDesigners) {
				int allPosts = colPostsWithIdDesigners.get(key);
				int allLikes = likeDAO.selectCountLikeByAllPosts(key);
				double rating = new BigDecimal((double) allLikes / allPosts)
						.setScale(1, RoundingMode.UP).doubleValue();
				User user = userDAO.selectUserById(key);
				user.setRating(rating);
				userDAO.updateUser(user);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public void addDefaultAdvertisement() throws ServiceException {
		DateFormat dateFormat = new SimpleDateFormat(
				ServiceParamConstant.FORMAT_DATE);
		Date date = new Date();
		String registrationDate = dateFormat.format(date);
		Advertisement advertisement = new Advertisement();
		advertisement.setTitle(propertyManagerG3DM
				.getValue(PropertyNameG3DM.ADVERTISEMENT_DEFAULT_TITLE));
		advertisement.setClient(propertyManagerG3DM
				.getValue(PropertyNameG3DM.ADVERTISEMENT_DEFAULT_CLIENT));
		advertisement.setDescription(propertyManagerG3DM
				.getValue(PropertyNameG3DM.ADVERTISEMENT_DEFAULT_DESCRIPTION));
		advertisement.setRegistrationDate(registrationDate);
		advertisement
				.setExpirationDate(propertyManagerG3DM
						.getValue(PropertyNameG3DM.ADVERTISEMENT_DEFAULT_EXPIRATION_DATE));
		advertisement.setFileName(propertyManagerG3DM.getValue(PropertyNameG3DM.ADVERTISEMENT_DEFAULT_FILE_NAME));
		advertisement.setFilePath(propertyManagerG3DM.getValue(PropertyNameG3DM.ADVERTISEMENT_DEFAULT_FILE_PATH));
		try {
			advertisementDAO.insertAdvertisement(advertisement);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public int getNumberOfAllUsers() throws ServiceException {
		int allUsers = 0;
		try {
			allUsers = userDAO.selectNumberOfAllUsers();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return allUsers;
	}

	@Override
	public int getNumberOfDesigners() throws ServiceException {
		int designers = 0;
		try {
			designers = userDAO.selectNumberOfDesigners();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return designers;
	}

	@Override
	public int getNumberOfModerators() throws ServiceException {
		int moderators = 0;
		try {
			moderators = userDAO.selectNumberOfModerators();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return moderators;
	}

	@Override
	public int getNumberOfUsers() throws ServiceException {
		int users = 0;
		try {
			users = userDAO.selectNumberOfUsers();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@Override
	public int getNumberOfAllPosts() throws ServiceException {
		int allPosts = 0;
		try {
			allPosts = postDAO.selectNumberOfAllPosts();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return allPosts;
	}

	@Override
	public int getNumberOfDeletedPosts() throws ServiceException {
		int deletedPosts = 0;
		try {
			deletedPosts = postDAO.selectNumberOfDeletedPosts();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return deletedPosts;
	}

	@Override
	public int getNumberOfRejectedPosts() throws ServiceException {
		int rejectedPosts = 0;
		try {
			rejectedPosts = postDAO.selectNumberOfRejectedPosts();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return rejectedPosts;
	}

	@Override
	public int getNumberOfModeratingPosts() throws ServiceException {
		int moderatingPosts = 0;
		try {
			moderatingPosts = postDAO.selectNumberOfModeratingPosts();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return moderatingPosts;
	}

	@Override
	public int getNumberOfPublishingPosts() throws ServiceException {
		int publishingPosts = 0;
		try {
			publishingPosts = postDAO.selectNumberOfPublishingPosts();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return publishingPosts;
	}

	@Override
	public int getNumberOfAdmins() throws ServiceException {
		int admins = 0;
		try {
			admins = userDAO.selectNumberOfAdmins();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return admins;
	}

}
