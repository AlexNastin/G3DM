package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.Comment;
import com.global3Dmod.ÇDmodels.domain.File;
import com.global3Dmod.ÇDmodels.domain.PasswordResetToken;
import com.global3Dmod.ÇDmodels.domain.Person;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.Subcategory;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.CommentForm;
import com.global3Dmod.ÇDmodels.form.SignupForm;

public interface IGuestService {

	public void addUser(SignupForm signupForm) throws ServiceException;

	public void addComment(CommentForm commentForm, Person person)
			throws ServiceException;

	public Person getPerson(String login) throws ServiceException;

	public List<String> getAllEmail() throws ServiceException;

	public List<String> getAllNickName() throws ServiceException;

	public List<Category> getAllCategories() throws ServiceException;

	public List<Subcategory> getAllSubcategories() throws ServiceException;

	public List<Subcategory> getTop3Subcategories(Integer id)
			throws ServiceException;

	public List<Category> getAllCategoriesSubcategoriesTop3()
			throws ServiceException;

	public List<Advertisement> getAllAdvertisement() throws ServiceException;

	public List<Post> getPostsLimit10(Integer page) throws ServiceException;

	public List<Post> getPostsLimit10ByCategory(Integer page, Integer idCategory)
			throws ServiceException;

	public List<Post> getPostsLimit10BySubcategory(Integer page,
			Integer idCategory, Integer idSubcategory) throws ServiceException;

	public Post getPost(Integer idPost) throws ServiceException;

	public User getUser(Integer idUser) throws ServiceException;

	public List<Comment> getCommentsByPost(Integer idPost)
			throws ServiceException;

	public List<Comment> sortCommentsByDate(List<Comment> comments)
			throws ServiceException;

	public void vote(Integer idUser, Integer idPost) throws ServiceException;

	public void complain(Integer idUser, Integer idPost)
			throws ServiceException;

	public int getCountLikeByPost(Integer idPost) throws ServiceException;

	public void setRatingInPosts(List<Post> posts) throws ServiceException;

	public double getRatingByDesigner(Integer idUser) throws ServiceException;

	public boolean createPasswordResetTokenForUser(User user, String token)
			throws ServiceException;

	public PasswordResetToken getPasswordResetToken(String token)
			throws ServiceException;

	public void updateForgotPassword(User user, String password)
			throws ServiceException;

	public List<Post> getTop4PostsByLike() throws ServiceException;

	public String getFileFullPath(Integer idFile) throws ServiceException;
}
