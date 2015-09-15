package com.global3Dmod.ÇDmodel.service;

import java.util.List;

import com.global3Dmod.ÇDmodel.domain.Advertisement;
import com.global3Dmod.ÇDmodel.domain.Category;
import com.global3Dmod.ÇDmodel.domain.Comment;
import com.global3Dmod.ÇDmodel.domain.PasswordResetToken;
import com.global3Dmod.ÇDmodel.domain.Person;
import com.global3Dmod.ÇDmodel.domain.Post;
import com.global3Dmod.ÇDmodel.domain.Subcategory;
import com.global3Dmod.ÇDmodel.domain.User;
import com.global3Dmod.ÇDmodel.exception.ServiceException;
import com.global3Dmod.ÇDmodel.form.AddModeratorForm;
import com.global3Dmod.ÇDmodel.form.CommentForm;
import com.global3Dmod.ÇDmodel.form.SignupForm;

public interface IGuestService {

	public void addUser(SignupForm signupForm, String serverPath)
			throws ServiceException;

	public void addModerator(AddModeratorForm addModeratorForm)
			throws ServiceException;

	public void addComment(CommentForm commentForm, Person person)
			throws ServiceException;

	public Person getPerson(String login) throws ServiceException;

	public List<String> getAllEmail() throws ServiceException;

	public List<String> getAllNickName() throws ServiceException;

	public List<Category> getAllCategories() throws ServiceException;
	
	public List<Category> getAllCategoriesWithSubcategories()throws ServiceException;

	public List<Subcategory> getAllSubcategories() throws ServiceException;

	public List<Subcategory> getTop3Subcategories(Integer id)
			throws ServiceException;

	public List<Category> getAllCategoriesSubcategoriesTop3()
			throws ServiceException;

	public List<Advertisement> getAllAdvertisement() throws ServiceException;

	public List<Post> getPosts() throws ServiceException;

	public List<Post> getPostsByCategory(Integer idCategory)
			throws ServiceException;

	public List<Post> getPostsByCategoryBySubcategory(Integer idCategory,
			Integer idSubcategory) throws ServiceException;

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

	public List<User> getTop4UsersByRating() throws ServiceException;

	public String getFileFullPath(Integer idFile) throws ServiceException;

	public void updateCountDownload(Integer idFile, short countDownload)
			throws ServiceException;
}
