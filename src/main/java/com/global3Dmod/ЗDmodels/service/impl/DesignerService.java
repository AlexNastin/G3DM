package com.global3Dmod.«Dmodels.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.«Dmodels.aop.annotation.AspectLogG3DM;
import com.global3Dmod.«Dmodels.dao.IAvatarDAO;
import com.global3Dmod.«Dmodels.dao.ICategoryDAO;
import com.global3Dmod.«Dmodels.dao.ICountryDAO;
import com.global3Dmod.«Dmodels.dao.IDisProgramDAO;
import com.global3Dmod.«Dmodels.dao.IPostDAO;
import com.global3Dmod.«Dmodels.dao.ITechnologyDAO;
import com.global3Dmod.«Dmodels.dao.IUserDAO;
import com.global3Dmod.«Dmodels.domain.Avatar;
import com.global3Dmod.«Dmodels.domain.Category;
import com.global3Dmod.«Dmodels.domain.City;
import com.global3Dmod.«Dmodels.domain.Country;
import com.global3Dmod.«Dmodels.domain.DisProgram;
import com.global3Dmod.«Dmodels.domain.Post;
import com.global3Dmod.«Dmodels.domain.PostPhoto;
import com.global3Dmod.«Dmodels.domain.Technology;
import com.global3Dmod.«Dmodels.domain.Subcategory;
import com.global3Dmod.«Dmodels.domain.User;
import com.global3Dmod.«Dmodels.exception.DaoException;
import com.global3Dmod.«Dmodels.exception.ServiceException;
import com.global3Dmod.«Dmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.«Dmodels.form.DesignerPersonalSecurityForm;
import com.global3Dmod.«Dmodels.form.PostForm;
import com.global3Dmod.«Dmodels.form.UpdatePostForm;
import com.global3Dmod.«Dmodels.form.regex.RegExCollection;
import com.global3Dmod.«Dmodels.form.regex.RegExName;
import com.global3Dmod.«Dmodels.property.PropertyManagerG3DM;
import com.global3Dmod.«Dmodels.property.PropertyNameG3DM;
import com.global3Dmod.«Dmodels.service.IDesignerService;
import com.global3Dmod.«Dmodels.service.ServiceParamConstant;
import com.global3Dmod.«Dmodels.service.helper.ServiceHelper;
import com.global3Dmod.«Dmodels.sort.country.SortedCountriesById;
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

	@Autowired
	private PropertyManagerG3DM propertyManager;

	@Autowired
	private RegExCollection regExCollection;

	@Autowired
	private IDisProgramDAO disProgramDAO;

	@Autowired
	private ICategoryDAO categoryDAO;

	@Autowired
	private ICountryDAO countryDAO;

	@Autowired
	private ITechnologyDAO printerDAO;

	@Autowired
	private IAvatarDAO avatarDAO;

	@Autowired
	private IPostDAO postDAO;

	@Autowired
	private IUserDAO userDAO;

	@AspectLogG3DM
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

	@AspectLogG3DM
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

	@AspectLogG3DM
	@Override
	public List<Country> getAllCountries() throws ServiceException {
		List<Country> countries;
		try {
			countries = countryDAO.selectAllCountries();
			for (int i = 0; i < countries.size(); i++) {
				countries.get(i).setCities(null);
				countries.get(i).setUsers(null);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return countries;
	}

	@AspectLogG3DM
	@Override
	public List<Subcategory> getAllSubcategoryWithinCategory(int idCategory)
			throws ServiceException {
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
		Category category1;
		try {
			category1 = categoryDAO.selectCategoryById(idCategory);
			subcategories = category1.getSubcategories();
			for (Subcategory subcategory : subcategories) {
				subcategory.setCategory(null);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return subcategories;
	}

	@AspectLogG3DM
	@Override
	public List<City> getAllCityWithinCountry(int idCountry)
			throws ServiceException {
		List<City> cities = new ArrayList<City>();
		Country country1;
		try {
			country1 = countryDAO.selectCountryById(idCountry);
			cities = country1.getCities();
			for (City city : cities) {
				city.setCountry(null);
				city.setUsers(null);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return cities;
	}

	@AspectLogG3DM
	@Override
	public List<Technology> getAllTechnologies() throws ServiceException {
		List<Technology> printers;
		try {
			printers = printerDAO.selectAllTechnologies();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return printers;
	}

	@AspectLogG3DM
	@Override
	public List<Technology> getCheckPrintersById(String[] printersId)
			throws ServiceException {
		List<Technology> printers;
		try {
			printers = printerDAO.selectCheckTechnologiesById(printersId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return printers;
	}

	@AspectLogG3DM
	@Override
	public void addPost(PostForm postForm, int idUser, String nickName,
			String serverPath) throws ServiceException {
		DateFormat dateFormat = new SimpleDateFormat(
				ServiceParamConstant.FORMAT_DATE);
		Date date = new Date();
		String registrationDate = dateFormat.format(date);
		Post post = new Post();
		post.setUser_idUser(idUser);
		post.setCategory_idCategory(postForm.getCategory_idCategory());
		post.setSubcategory_idSubcategory(postForm
				.getSubcategory_idSubcategory());
		post.setNumberPost(ServiceHelper.generationNumberPost(date, nickName,
				postForm.getCategory_idCategory(),
				postForm.getSubcategory_idSubcategory()));
		post.setDisProgram_idDisProgram(postForm.getDisProgram_idDisProgram());
		post.setDateReg(registrationDate);
		post.setDateUpdate(registrationDate);
		post.setTitle(postForm.getTitle());
		post.setDescription(postForm.getDescription());
		post.setInstruction(postForm.getInstruction());
		post.setIsDisplay(ServiceParamConstant.DEFAULT_IS_DISPLAY);
		post.setCountDownload(ServiceParamConstant.DEFAULT_COUNT);
		post.setTechnologies(getCheckPrintersById(postForm.getTechnologiesId()));
		long time = date.getTime();

		String pathModel = createPostPath(idUser, time);
		String pathModelPhoto = createPostPath(idUser, time);

		String fullPathModel = serverPath.concat(pathModel);
		String fullPathModelPhoto = serverPath.concat(pathModelPhoto);

		PostPhoto firstPostPhoto = new PostPhoto();
		firstPostPhoto.setFolder(time);
		String newName = photoModelFileUpload(postForm.getFirstPhoto(),
				fullPathModelPhoto);
		firstPostPhoto.setFileName(newName);
		firstPostPhoto.setPhotoPath(pathModelPhoto + newName);
		firstPostPhoto.setPost(post);
		List<PostPhoto> postPhotos = new ArrayList<PostPhoto>();
		postPhotos.add(firstPostPhoto);
		post.setPostPhotos(postPhotos);

		com.global3Dmod.«Dmodels.domain.File file = new com.global3Dmod.«Dmodels.domain.File();
		file.setFolder(time);
		newName = modelFileUpload(postForm.getModel(), fullPathModel);
		file.setFileName(newName);
		file.setFilePath(pathModel + newName);
		file.setPost(post);
		post.setFile(file);

		try {
			postDAO.insertPost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
	@Override
	public String modelFileUpload(MultipartFile file, String path)
			throws ServiceException {
		String orgName = file.getOriginalFilename();
		String newName = createNewNameFile(orgName);
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
	public String modelFileUpload(MultipartFile file, String path,
			String oldFileName) throws ServiceException {
		String orgName = file.getOriginalFilename();
		Pattern pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_FILE_EXT);
		Matcher matcher = pattern.matcher(orgName);
		String orgNameExt = "";
		String oldNameExt = "";
		String nameFile = "";
		while (matcher.find()) {
			orgNameExt = orgName.substring(matcher.start(), matcher.end());
		}
		matcher = pattern.matcher(oldFileName);
		while (matcher.find()) {
			oldNameExt = oldFileName.substring(matcher.start(), matcher.end());
		}
		if (oldNameExt.equalsIgnoreCase(orgNameExt)) {
			nameFile = oldFileName;
		} else {
			nameFile = createNewNameFile(orgName);

		}
		String filePath = path + nameFile;
		new File(path).mkdirs();
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
		return nameFile;
	}

	@AspectLogG3DM
	@Override
	public String photoModelFileUpload(MultipartFile file, String path)
			throws ServiceException {
		String orgName = file.getOriginalFilename();
		String newName = createNewNameFile(orgName);
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
	public String photoModelFileUpload(MultipartFile file, String path,
			String oldFileName) throws ServiceException {
		String orgName = file.getOriginalFilename();
		Pattern pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_FILE_EXT);
		Matcher matcher = pattern.matcher(orgName);
		String orgNameExt = "";
		String oldNameExt = "";
		String nameFile = "";
		while (matcher.find()) {
			orgNameExt = orgName.substring(matcher.start(), matcher.end());
		}
		matcher = pattern.matcher(oldFileName);
		while (matcher.find()) {
			oldNameExt = oldFileName.substring(matcher.start(), matcher.end());
		}
		if (oldNameExt.equalsIgnoreCase(orgNameExt)) {
			nameFile = oldFileName;
		} else {
			nameFile = createNewNameFile(orgName);

		}
		String filePath = path + nameFile;
		new File(path).mkdirs();
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
		return nameFile;
	}

	@AspectLogG3DM
	@Override
	public String avatarFileUpload(MultipartFile file, String path)
			throws ServiceException {
		String orgName = file.getOriginalFilename();
		String newName = createNewNameFile(orgName);
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
	public String avatarFileUpload(MultipartFile file, String path,
			String oldFileName) throws ServiceException {
		String orgName = file.getOriginalFilename();
		Pattern pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_FILE_EXT);
		Matcher matcher = pattern.matcher(orgName);
		String orgNameExt = "";
		String oldNameExt = "";
		String nameFile = "";
		while (matcher.find()) {
			orgNameExt = orgName.substring(matcher.start(), matcher.end());
		}
		matcher = pattern.matcher(oldFileName);
		while (matcher.find()) {
			oldNameExt = oldFileName.substring(matcher.start(), matcher.end());
		}
		if (oldNameExt.equalsIgnoreCase(orgNameExt)) {
			nameFile = oldFileName;
		} else {
			nameFile = createNewNameFile(orgName);

		}
		String filePath = path + nameFile;
		new File(path).mkdirs();
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
		return nameFile;
	}

	@AspectLogG3DM
	@Override
	public List<Post> getPostsByDesigner(Integer idUser)
			throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByDesigner(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public List<Post> getPostsByDesignerForSort(Integer idUser)
			throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByDesignerForSort(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@Override
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc) {
		if (sort != null) {
			if (ServiceParamConstant.TITLE.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByTitleDesc());
				} else {
					Collections.sort(posts, new SortedPostsByTitle());
				}
			} else if (ServiceParamConstant.CATEGORY.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByCategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsByCategory());
				}
			} else if (ServiceParamConstant.SUBCATEGORY.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsBySubcategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsBySubcategory());
				}
			} else if (ServiceParamConstant.DATE.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByDateDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDate());
				}
			} else if (ServiceParamConstant.DOWNLOADS.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByDownloadsDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDownloads());
				}
			} else if (ServiceParamConstant.STATUS.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByStatusDesc());
				} else {
					Collections.sort(posts, new SortedPostsByStatus());
				}
			}
		}
		return posts;
	}

	@Override
	public List<Country> sortCountries(List<Country> countries) {
		Collections.sort(countries, new SortedCountriesById());
		return countries;
	}

	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) {
		if (ServiceParamConstant.CATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, false);
		}
		if (ServiceParamConstant.DATE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, false);
		}
		if (ServiceParamConstant.DOWNLOADS.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DOWNLOADS_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DOWNLOADS_DESC, false);
		}
		if (ServiceParamConstant.STATUS.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.STATUS_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.STATUS_DESC, false);
		}
		if (ServiceParamConstant.SUBCATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.SUBCATEGORY_DESC, true);
		} else {
			modelAndView
					.addObject(ServiceParamConstant.SUBCATEGORY_DESC, false);
		}
		if (ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		return modelAndView;
	}

	@AspectLogG3DM
	@Override
	public User getUser(String login) throws ServiceException {
		User user;
		try {
			user = userDAO.selectUser(login);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@AspectLogG3DM
	@Override
	public void updateUser(DesignerPersonalDataForm personalDataForm,
			String login, String serverPath) throws ServiceException {
		try {
			User user = userDAO.selectUser(login);
			user.setCountry_idCountry(personalDataForm.getCountry_idCountry());
			user.setCity_id—ity(personalDataForm.getCity_idCity());
			user.setName(personalDataForm.getName());
			user.setSurname(personalDataForm.getSurname());
			user.setGender(personalDataForm.getGender());
			user.setDateBirth(personalDataForm.getDateBirth());
			if (!personalDataForm.getAvatar().isEmpty()) {
				String pathAvatar = createAvatarPath(user.getIdUser());
				String fullPathAvatar = serverPath.concat(pathAvatar);
				Avatar avatar = user.getAvatar();
				avatar.setAvatarPath(pathAvatar
						+ avatarFileUpload(personalDataForm.getAvatar(),
								fullPathAvatar, avatar.getFileName()));
				user.setAvatar(avatar);
			}
			userDAO.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
	@Override
	public void updatePassword(
			DesignerPersonalSecurityForm personalSecurityForm, String login)
			throws ServiceException {
		try {
			User user = userDAO.selectUser(login);
			String password = personalSecurityForm.getPassword();
			if (password != null) {
				String md5Password = DigestUtils.md5Hex(password);
				user.setPassword(md5Password);
			}
			userDAO.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
	@Override
	public void updatePost(UpdatePostForm updatePostForm, Integer idPost,
			String serverPath) throws ServiceException {
		try {
			Post post = postDAO.selectPost(idPost);
			DateFormat dateFormat = new SimpleDateFormat(
					ServiceParamConstant.FORMAT_DATE);
			Date date = new Date();
			String dateUpdate = dateFormat.format(date);
			post.setCategory_idCategory(updatePostForm.getCategory_idCategory());
			post.setSubcategory_idSubcategory(updatePostForm
					.getSubcategory_idSubcategory());
			post.setDisProgram_idDisProgram(updatePostForm
					.getDisProgram_idDisProgram());
			post.setDateUpdate(dateUpdate);
			post.setTitle(updatePostForm.getTitle());
			post.setDescription(updatePostForm.getDescription());
			post.setInstruction(updatePostForm.getInstruction());
			post.setIsDisplay(2);
			post.setTechnologies(getCheckPrintersById(updatePostForm
					.getTechnologiesId()));
			if (!updatePostForm.getModelUpdate().isEmpty()) {
				String pathModel = createPostPath(post.getUser_idUser(), post
						.getFile().getFolder());
				String fullPathModel = serverPath.concat(pathModel);
				com.global3Dmod.«Dmodels.domain.File file = post.getFile();
				file.setFilePath(pathModel
						+ modelFileUpload(updatePostForm.getModelUpdate(),
								fullPathModel, file.getFileName()));
				post.setFile(file);
			}
			if (!updatePostForm.getFirstPhotoUpdate().isEmpty()) {
				String pathModelPhoto = createPostPath(post.getUser_idUser(),
						post.getPostPhotos().get(0).getFolder());

				String fullPathModelPhoto = serverPath.concat(pathModelPhoto);

				PostPhoto firstPostPhoto = post.getPostPhotos().get(0);
				firstPostPhoto.setPhotoPath(pathModelPhoto
						+ photoModelFileUpload(
								updatePostForm.getFirstPhotoUpdate(),
								fullPathModelPhoto,
								firstPostPhoto.getFileName()));

				List<PostPhoto> postPhotos = new ArrayList<PostPhoto>();
				postPhotos.add(firstPostPhoto);
				post.setPostPhotos(postPhotos);
			}

			postDAO.updatePost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public void deletePost(Integer idPost) throws ServiceException {
		try {
			Post post = postDAO.selectPostWithoutAll(idPost);
			post.setIsDisplay(0);
			postDAO.updatePost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public Post getPost(Integer idPost) throws ServiceException {
		Post post = null;
		try {
			post = postDAO.selectPost(idPost);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return post;
	}

	@AspectLogG3DM
	@Override
	public void deleteAvatar(Avatar avatar) throws ServiceException {
		try {
			avatar.setAvatarPath(propertyManager
					.getValue(PropertyNameG3DM.DEFAULT_AVATAR_PATH));
			avatar.setFileName(propertyManager
					.getValue(PropertyNameG3DM.DEFAULT_AVATAR_NAME));
			avatarDAO.updateAvatar(avatar);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	private String createPostPath(int idUser, long time) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("/resources/files/");
		stringBuilder.append(idUser);
		stringBuilder.append("/posts/");
		stringBuilder.append(time);
		stringBuilder.append("/");
		String path = stringBuilder.toString();
		return path;
	}

	@Override
	public String createAvatarPath(int idUser) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("/resources/files/");
		stringBuilder.append(idUser);
		stringBuilder.append("/avatar/");
		String path = stringBuilder.toString();
		return path;
	}

	@Override
	public String createNewNameFile(String name) {
		Pattern pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_FILE_EXT);
		Matcher matcher = pattern.matcher(name);
		int hashCode = name.hashCode();
		if (hashCode < 0) {
			hashCode = hashCode * (-1);
		}
		if (hashCode == 0) {
			++hashCode;
		}
		StringBuilder newName = new StringBuilder(String.valueOf(hashCode));
		while (matcher.find()) {
			newName.append(name.substring(matcher.start(), matcher.end()));
		}
		return newName.toString();
	}
}
