package com.global3Dmod.«Dmodels.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.«Dmodels.aop.annotation.AspectLogG3DM;
import com.global3Dmod.«Dmodels.dao.IPostDAO;
import com.global3Dmod.«Dmodels.dao.IUserDAO;
import com.global3Dmod.«Dmodels.domain.Avatar;
import com.global3Dmod.«Dmodels.domain.Post;
import com.global3Dmod.«Dmodels.domain.User;
import com.global3Dmod.«Dmodels.exception.DaoException;
import com.global3Dmod.«Dmodels.exception.ServiceException;
import com.global3Dmod.«Dmodels.form.UserPersonalDataForm;
import com.global3Dmod.«Dmodels.form.UserPersonalSecurityForm;
import com.global3Dmod.«Dmodels.property.PropertyManagerG3DM;
import com.global3Dmod.«Dmodels.service.IDesignerService;
import com.global3Dmod.«Dmodels.service.IUserService;
import com.global3Dmod.«Dmodels.service.ServiceParamConstant;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDesigner;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByDesignerDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByRating;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByRatingDesc;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.«Dmodels.sort.post.SortedPostsByTitleDesc;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IPostDAO postDAO;
	
	@Autowired
	private PropertyManagerG3DM propertyManagerG3DM;
	
	@Autowired
	private IDesignerService designerService;

	@AspectLogG3DM
	@Override
	public List<User> getAllUsers() throws ServiceException {
		List<User> users = null;

		try {
			users = userDAO.selectAllUsers();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return users;
	}

	@AspectLogG3DM
	@Override
	public List<User> getTop3Users() throws ServiceException {
		List<User> users = null;
		try {
			users = userDAO.selectTop3Users();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	
	@Override
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc) {
		if (sort != null) {
			if (ServiceParamConstant.TITLE.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByTitleDesc());
				} else {
					Collections.sort(posts, new SortedPostsByTitle());
				}	
			} else if (ServiceParamConstant.RATING.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByRatingDesc());
				} else {
					Collections.sort(posts, new SortedPostsByRating());
				}
			} else if (ServiceParamConstant.DESIGNER.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByDesignerDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDesigner());
				}
			} 
		}
		return posts;
	}
	
	
	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,	String sort, boolean desc) {
		if(ServiceParamConstant.RATING.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.RATING_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.RATING_DESC, false);
		}
		if(ServiceParamConstant.DESIGNER.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, false);
		}
		if(ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		return modelAndView;
	}

	@AspectLogG3DM
	@Override
	public List<Post> getPostsByUserForSort(Integer idUser)
			throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByUserForSort(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}
	
	@AspectLogG3DM
	@Override
	public void updateUser(UserPersonalDataForm personalDataForm, String login, String serverPath)
			throws ServiceException {
		try {
			User user = userDAO.selectUser(login);
			user.setCountry_idCountry(personalDataForm.getCountry_idCountry());
			user.setCity_id—ity(personalDataForm.getCity_idCity());
			user.setName(personalDataForm.getName());
			user.setSurname(personalDataForm.getSurname());
			user.setGender(personalDataForm.getGender());
			user.setDateBirth(personalDataForm.getDateBirth());
			
			String pathAvatar = designerService.createAvatarPath(user.getIdUser());
			String fullPathAvatar = serverPath.concat(pathAvatar);
			Avatar avatar = user.getAvatar();
			avatar.setAvatarPath(pathAvatar + designerService.avatarFileUpload(personalDataForm.getAvatar(), fullPathAvatar, avatar.getFileName()));
			user.setAvatar(avatar);
			
			userDAO.updateUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
	@Override
	public void updatePassword(UserPersonalSecurityForm personalSecurityForm,
			String login) throws ServiceException {
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
	public void setPathToPhotos(List<Post> posts) throws ServiceException {
//		for (Post post : posts) {
//			String oldPath = post.getPostPhotos().get(0).getPhotoPath();
//			StringBuilder fullPath = new StringBuilder(propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE));
//			fullPath.append(oldPath);
//			post.getPostPhotos().get(0).setPhotoPath(fullPath.toString());
//		}
	}

	@AspectLogG3DM
	@Override
	public void setPathToPhotos(Post post) throws ServiceException {
//		String oldPath = post.getPostPhotos().get(0).getPhotoPath();
//		StringBuilder fullPath = new StringBuilder(propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE));
//		fullPath.append(oldPath);
//		post.getPostPhotos().get(0).setPhotoPath(fullPath.toString());
	}
	
	@AspectLogG3DM
	@Override
	public void setPathToPhotos(User user) throws ServiceException {
//		String oldPath = user.getAvatar().getAvatarPath();
//		StringBuilder fullPath = new StringBuilder(propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE));
//		fullPath.append(oldPath);
//		user.getAvatar().setAvatarPath(fullPath.toString());
	}
	
	@AspectLogG3DM
	@Override
	public void setPathToPhotosUsers(List<User> users) throws ServiceException {
//		for (User user : users) {
//			String oldPath = user.getAvatar().getAvatarPath();
//			StringBuilder fullPath = new StringBuilder(propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE));
//			fullPath.append(oldPath);
//			user.getAvatar().setAvatarPath(fullPath.toString());
//		}
	}

}
