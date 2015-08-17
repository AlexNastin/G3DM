package com.global3Dmod.«Dmodels.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global3Dmod.«Dmodels.aop.annotation.AspectLogG3DM;
import com.global3Dmod.«Dmodels.dao.IAdvertisementDAO;
import com.global3Dmod.«Dmodels.dao.ICategoryDAO;
import com.global3Dmod.«Dmodels.dao.ICommentDAO;
import com.global3Dmod.«Dmodels.dao.IComplainDAO;
import com.global3Dmod.«Dmodels.dao.IFileDAO;
import com.global3Dmod.«Dmodels.dao.ILikeDAO;
import com.global3Dmod.«Dmodels.dao.IPasswordResetTokenDAO;
import com.global3Dmod.«Dmodels.dao.IPostDAO;
import com.global3Dmod.«Dmodels.dao.ISubcategoryDAO;
import com.global3Dmod.«Dmodels.dao.IUserDAO;
import com.global3Dmod.«Dmodels.domain.Advertisement;
import com.global3Dmod.«Dmodels.domain.Avatar;
import com.global3Dmod.«Dmodels.domain.Category;
import com.global3Dmod.«Dmodels.domain.Comment;
import com.global3Dmod.«Dmodels.domain.Complain;
import com.global3Dmod.«Dmodels.domain.File;
import com.global3Dmod.«Dmodels.domain.Like;
import com.global3Dmod.«Dmodels.domain.PasswordResetToken;
import com.global3Dmod.«Dmodels.domain.Person;
import com.global3Dmod.«Dmodels.domain.Post;
import com.global3Dmod.«Dmodels.domain.Subcategory;
import com.global3Dmod.«Dmodels.domain.User;
import com.global3Dmod.«Dmodels.exception.DaoException;
import com.global3Dmod.«Dmodels.exception.ServiceException;
import com.global3Dmod.«Dmodels.form.AddModeratorForm;
import com.global3Dmod.«Dmodels.form.CommentForm;
import com.global3Dmod.«Dmodels.form.SignupForm;
import com.global3Dmod.«Dmodels.property.PropertyManagerG3DM;
import com.global3Dmod.«Dmodels.property.PropertyNameG3DM;
import com.global3Dmod.«Dmodels.service.IDesignerService;
import com.global3Dmod.«Dmodels.service.IGuestService;
import com.global3Dmod.«Dmodels.service.ServiceParamConstant;
import com.global3Dmod.«Dmodels.sort.comment.SortedCommentsByDate;

@Service
public class GuestService implements IGuestService {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IDesignerService designerService;

	@Autowired
	private IPostDAO postDAO;

	@Autowired
	private IAdvertisementDAO advertisementDAO;

	@Autowired
	private ICategoryDAO categoryDAO;

	@Autowired
	private ISubcategoryDAO subcategoryDAO;

	@Autowired
	private ICommentDAO commentDAO;

	@Autowired
	private ILikeDAO likeDAO;

	@Autowired
	private IComplainDAO complainDAO;

	@Autowired
	private IPasswordResetTokenDAO resetTokenDAO;

	@Autowired
	private IFileDAO fileDAO;

	@Autowired
	private PropertyManagerG3DM propertyManager;

	@AspectLogG3DM
	@Override
	public void addUser(SignupForm signupForm, String serverPath)
			throws ServiceException {
		User user = new User();
		DateFormat dateFormat = new SimpleDateFormat(
				ServiceParamConstant.FORMAT_DATE);
		Date date = new Date();
		String registrationDate = dateFormat.format(date);
		String md5Password = DigestUtils.md5Hex(signupForm.getPassword());
		user.setRole_idRole(signupForm.getRole_idRole());
		user.setCountry_idCountry(ServiceParamConstant.ID_—OUNTRY);
		user.setCity_id—ity(ServiceParamConstant.ID_—ITY);
		user.setNickName(signupForm.getNickName());
		user.setLogin(signupForm.getLogin().toLowerCase());
		user.setPassword(md5Password);
		user.setName(ServiceParamConstant.EMPTY);
		user.setSurname(ServiceParamConstant.EMPTY);
		user.setGender(0);
		user.setRegistrationDate(registrationDate);

		Avatar avatar = new Avatar();
		String newName = ServiceParamConstant.DEFAULT_NAME_AVATAR;
		avatar.setFileName(newName);
		avatar.setAvatarPath(ServiceParamConstant.PATH_TO_DEFAULT_AVATAR
				+ newName);
		avatar.setUser(user);

		user.setAvatar(avatar);

		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public void addModerator(AddModeratorForm addModeratorForm)
			throws ServiceException {
		User user = new User();
		DateFormat dateFormat = new SimpleDateFormat(
				ServiceParamConstant.FORMAT_DATE);
		Date date = new Date();
		String registrationDate = dateFormat.format(date);
		String md5Password = DigestUtils.md5Hex(addModeratorForm.getPassword());
		user.setRole_idRole(4);
		user.setCountry_idCountry(ServiceParamConstant.ID_—OUNTRY);
		user.setCity_id—ity(ServiceParamConstant.ID_—ITY);
		user.setNickName(addModeratorForm.getNickName());
		user.setLogin(addModeratorForm.getLogin().toLowerCase());
		user.setPassword(md5Password);
		user.setName(addModeratorForm.getNameModerator());
		user.setSurname(addModeratorForm.getSurnameModerator());
		user.setGender(0);
		user.setRegistrationDate(registrationDate);

		Avatar avatar = new Avatar();
		String newName = ServiceParamConstant.DEFAULT_NAME_AVATAR;
		avatar.setFileName(newName);
		avatar.setAvatarPath(ServiceParamConstant.PATH_TO_DEFAULT_AVATAR
				+ newName);
		avatar.setUser(user);
		user.setAvatar(avatar);

		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public void addComment(CommentForm commentForm, Person person)
			throws ServiceException {
		Comment comment = new Comment();
		Date date = new Date();
		comment.setDateTime(date);
		comment.setPost_idPost(commentForm.getIdPost());
		comment.setUser_idUser(person.getIdPerson());
		comment.setText(commentForm.getComment());
		try {
			commentDAO.insertComment(comment);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public List<String> getAllEmail() throws ServiceException {
		List<String> emails;
		try {
			emails = userDAO.selectAllEmail();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return emails;
	}

	@AspectLogG3DM
	@Override
	public void vote(Integer idUser, Integer idPost) throws ServiceException {
		try {
			List<Like> likes = likeDAO.selectLikeNotExists(idUser, idPost);
			if (likes.isEmpty()) {
				Like likeUser = new Like();
				likeUser.setUsers_idUser(idUser);
				likeUser.setPosts_idPost(idPost);
				likeDAO.insertLike(likeUser);
			} else {
				likeDAO.deleteLike(likes.get(0).getIdLike());
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@AspectLogG3DM
	@Override
	public void complain(Integer idUser, Integer idPost)
			throws ServiceException {
		try {
			List<Complain> complains = complainDAO.selectComplainNotExists(
					idUser, idPost);
			if (complains.isEmpty()) {
				Complain complainUser = new Complain();
				complainUser.setUser_idUser(idUser);
				complainUser.setPost_idPost(idPost);
				complainDAO.insertComplain(complainUser);
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public List<String> getAllNickName() throws ServiceException {
		List<String> nickNames;
		try {
			nickNames = userDAO.selectAllNickName();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return nickNames;
	}

	@AspectLogG3DM
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

	@AspectLogG3DM
	@Override
	public List<Subcategory> getAllSubcategories() throws ServiceException {
		List<Subcategory> subcategories;
		try {
			subcategories = subcategoryDAO.selectAllSubcategories();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return subcategories;
	}

	@AspectLogG3DM
	@Override
	public List<Subcategory> getTop3Subcategories(Integer id)
			throws ServiceException {
		List<Subcategory> subcategoriesTop;
		try {
			subcategoriesTop = subcategoryDAO.selectTop3Subcategories(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return subcategoriesTop;
	}

	@AspectLogG3DM
	@Override
	public List<Category> getAllCategoriesSubcategoriesTop3()
			throws ServiceException {
		List<Category> categories = getAllCategories();
		for (Category category : categories) {
			category.setSubcategories(getTop3Subcategories(category
					.getIdCategory()));
		}
		return categories;
	}

	@AspectLogG3DM
	@Override
	public Person getPerson(String login) throws ServiceException {
		Person person = new Person();
		try {
			User user = userDAO.selectUser(login);
			person.setIdPerson(user.getIdUser());
			person.setLogin(user.getLogin());
			person.setNickName(user.getNickName());
			person.setName(user.getName());
			person.setSurName(user.getSurname());
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return person;
	}

	@AspectLogG3DM
	@Override
	public List<Advertisement> getAllAdvertisement() throws ServiceException {
		List<Advertisement> advertisements = new ArrayList<Advertisement>();
		DateFormat dateFormat = new SimpleDateFormat(
				ServiceParamConstant.FORMAT_DATE);
		Date date = new Date();
		String presentDate = dateFormat.format(date);
		try {
			advertisements = advertisementDAO.selectAllAdvertisements();
			for (int i = 0; i < advertisements.size(); i++) {
				if (presentDate.compareTo(advertisements.get(i)
						.getExpirationDate()) > 0) {
					advertisements.remove(i);
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return advertisements;
	}

	@AspectLogG3DM
	@Override
	public List<Post> getPostsLimit10(Integer page) throws ServiceException {
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.selectPostsLimit10(page);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public List<Post> getPostsLimit10ByCategory(Integer page, Integer idCategory)
			throws ServiceException {
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.selectPostsLimit10ByCategory(page, idCategory);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public List<Post> getPostsLimit10BySubcategory(Integer page,
			Integer idCategory, Integer idSubcategory) throws ServiceException {
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDAO.selectPostsLimit10BySubcategory(page, idCategory,
					idSubcategory);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public Post getPost(Integer idPost) throws ServiceException {
		Post post = new Post();
		try {
			post = postDAO.selectPost(idPost);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return post;
	}

	@AspectLogG3DM
	@Override
	public List<Comment> getCommentsByPost(Integer idPost)
			throws ServiceException {
		List<Comment> comments = new ArrayList<Comment>();
		try {
			comments = commentDAO.selectCommentsByPost(idPost);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return comments;
	}

	@Override
	public List<Comment> sortCommentsByDate(List<Comment> comments) {
		Collections.sort(comments, new SortedCommentsByDate());
		return comments;
	}

	@AspectLogG3DM
	@Override
	public User getUser(Integer idUser) throws ServiceException {
		User user = new User();
		try {
			user = userDAO.selectUserById(idUser);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@AspectLogG3DM
	@Override
	public int getCountLikeByPost(Integer idPost) throws ServiceException {
		int count;
		try {
			count = likeDAO.selectCountLikeByPost(idPost);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return count;
	}

	@AspectLogG3DM
	@Override
	public void setRatingInPosts(List<Post> posts) throws ServiceException {
		for (Post post : posts) {
			post.setRating(getCountLikeByPost(post.getIdPost()));
		}
	}

	@AspectLogG3DM
	@Override
	public double getRatingByDesigner(Integer idUser) throws ServiceException {
		double rating = 0;
		try {
			int allPosts = postDAO.countPostByDesigner(idUser);
			int allLikes = likeDAO.selectCountLikeByAllPosts(idUser);
			rating = new BigDecimal((double) allLikes / allPosts).setScale(1,
					RoundingMode.UP).doubleValue();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return rating;
	}

	@AspectLogG3DM
	@Override
	public boolean createPasswordResetTokenForUser(User user, String token)
			throws ServiceException {
		boolean isCreate = false;
		Date date = new Date();
		try {
			PasswordResetToken passwordResetTokenOld = resetTokenDAO
					.selectTokenByUser(user.getIdUser());
			if (passwordResetTokenOld == null) {
				PasswordResetToken passwordResetTokenNew = new PasswordResetToken();
				passwordResetTokenNew.setExpiryDate(new Date(
						date.getTime() + 86400000l));
				passwordResetTokenNew.setUser_idUser(user.getIdUser());
				passwordResetTokenNew.setToken(token);
				resetTokenDAO.insertPasswordResetToken(passwordResetTokenNew);
				isCreate = true;
			} else {
				Calendar calendar = Calendar.getInstance();
				if (passwordResetTokenOld.getExpiryDate().getTime()
						- calendar.getTime().getTime() <= 0) {
					passwordResetTokenOld.setExpiryDate(new Date(
							date.getTime() + 86400000l));
					passwordResetTokenOld.setToken(token);
					resetTokenDAO
							.updatePasswordResetToken(passwordResetTokenOld);
					isCreate = true;
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return isCreate;
	}

	@AspectLogG3DM
	@Override
	public PasswordResetToken getPasswordResetToken(String token)
			throws ServiceException {
		PasswordResetToken passwordResetToken = null;
		try {
			passwordResetToken = resetTokenDAO.selectTokenByToken(token);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return passwordResetToken;
	}

	@AspectLogG3DM
	@Override
	public void updateForgotPassword(User user, String password)
			throws ServiceException {
		String md5Password = DigestUtils.md5Hex(password);
		user.setPassword(md5Password);
		try {
			PasswordResetToken passwordResetToken = resetTokenDAO
					.selectTokenByUser(user.getIdUser());
			userDAO.updateUser(user);
			resetTokenDAO.deletePasswordResetToken(passwordResetToken
					.getIdToken());
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectLogG3DM
	@Override
	public List<Post> getTop4PostsByLike() throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectTop4ByLike();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}

	@AspectLogG3DM
	@Override
	public List<User> getTop4UsersByRating() throws ServiceException {
		List<User> users;
		try {
			users = userDAO.selectTop4ByRating();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return users;
	}

	@AspectLogG3DM
	@Override
	public String getFileFullPath(Integer idFile) throws ServiceException {
		StringBuilder fullPath = new StringBuilder(propertyManager.getValue(PropertyNameG3DM.PATH_FILE));
		try {
			File file = fileDAO.selectFileById(idFile);
			String pathFile = file.getFilePath();
			fullPath.append(pathFile);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return fullPath.toString();
	}

	@AspectLogG3DM
	@Override
	public void updateCountDownload(Integer idFile, short countDownload)
			throws ServiceException {
		try {
			File file = fileDAO.selectFileById(idFile);
			Post post = file.getPost();
			post.setCountDownload(countDownload);
			postDAO.updatePost(post);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
