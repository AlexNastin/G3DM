package com.global3Dmod.«Dmodels.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.«Dmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.«Dmodels.controller.ControllerParamConstant;
import com.global3Dmod.«Dmodels.dao.IAdvertisementDAO;
import com.global3Dmod.«Dmodels.dao.ICategoryDAO;
import com.global3Dmod.«Dmodels.dao.ICommentDAO;
import com.global3Dmod.«Dmodels.dao.IComplainDAO;
import com.global3Dmod.«Dmodels.dao.ILikeDAO;
import com.global3Dmod.«Dmodels.dao.IPostDAO;
import com.global3Dmod.«Dmodels.dao.IRatingDAO;
import com.global3Dmod.«Dmodels.dao.ISubcategoryDAO;
import com.global3Dmod.«Dmodels.dao.IUserDAO;
import com.global3Dmod.«Dmodels.domain.Advertisement;
import com.global3Dmod.«Dmodels.domain.Category;
import com.global3Dmod.«Dmodels.domain.Comment;
import com.global3Dmod.«Dmodels.domain.Complain;
import com.global3Dmod.«Dmodels.domain.Like;
import com.global3Dmod.«Dmodels.domain.Person;
import com.global3Dmod.«Dmodels.domain.Post;
import com.global3Dmod.«Dmodels.domain.Rating;
import com.global3Dmod.«Dmodels.domain.Subcategory;
import com.global3Dmod.«Dmodels.domain.User;
import com.global3Dmod.«Dmodels.exception.DaoException;
import com.global3Dmod.«Dmodels.exception.ServiceException;
import com.global3Dmod.«Dmodels.form.CommentForm;
import com.global3Dmod.«Dmodels.form.SignupForm;
import com.global3Dmod.«Dmodels.service.IGuestService;
import com.global3Dmod.«Dmodels.service.ServiceParamConstant;
import com.global3Dmod.«Dmodels.sort.comment.SortedCommentsByDate;

@Service
public class GuestService implements IGuestService {

	@Autowired
	private IUserDAO userDAO;

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
	private IRatingDAO ratingDAO;

	@Autowired
	private ILikeDAO likeDAO;
	
	@Autowired
	private IComplainDAO complainDAO;

	@Override
	public void addUser(SignupForm signupForm) throws ServiceException {
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
		user.setLogin(signupForm.getLogin());
		user.setPassword(md5Password);
		user.setName(ServiceParamConstant.EMPTY);
		user.setSurname(ServiceParamConstant.EMPTY);
		user.setGender(0);
		user.setRegistrationDate(registrationDate);
		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addComment(CommentForm commentForm, Person person)
			throws ServiceException {
		Comment comment = new Comment();
		Date date = new Date();
		comment.setDateTime(date);
		comment.setPost_idPost(commentForm.getIdPost());
		comment.setUser_idUser(person.getIdPerson());
		comment.setText(commentForm.getText());
		try {
			commentDAO.insertComment(comment);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@AspectDaoG3DM
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
	
	@Override
	public void complain(Integer idUser, Integer idPost)
			throws ServiceException {
		try {
			List<Complain> complains = complainDAO.selectComplainNotExists(idUser, idPost);
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

	@Override
	public List<Advertisement> getAllAdvertisement() throws ServiceException {
		List<Advertisement> advertisements = new ArrayList<Advertisement>();
		try {
			advertisements = advertisementDAO.selectAllAdvertisements();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return advertisements;
	}

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
	public List<Comment> sortCommentsByDate(List<Comment> comments)
			throws ServiceException {
		Collections.sort(comments, new SortedCommentsByDate());
		return comments;
	}

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

	@Override
	public void setRatingInPosts(List<Post> posts) throws ServiceException {
		for (Post post : posts) {
			post.setRating(getCountLikeByPost(post.getIdPost()));
		}
	}

	@Override
	public double getRatingByDesigner(Integer idUser) throws ServiceException {
		double rating = 0;
		try {
			int allPosts = postDAO.countPostByDesigner(idUser);
			int allLikes = likeDAO.selectCountLikeByAllPosts(idUser);
			rating = new BigDecimal((double)allLikes/allPosts).setScale(1, RoundingMode.UP).doubleValue();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return rating;
	}
}
