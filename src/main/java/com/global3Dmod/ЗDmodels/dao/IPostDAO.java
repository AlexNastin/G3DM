package com.global3Dmod.ÇDmodels.dao;

import java.util.List;
import java.util.Map;

import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IPostDAO {
	
	public void updatePost(Post post) throws DaoException;

	public void insertPost(Post post) throws DaoException;

	public List<Post> selectAllPosts() throws DaoException;
	
	public List<Post> selectPostsByDesigner(Integer idDesigner) throws DaoException;
	
	public List<Post> selectPostsByDesignerForSort(Integer idDesigner) throws DaoException;
	
	public List<Post> selectPostsByUserForSort(Integer idDesigner) throws DaoException;
	
	public List<Post> selectPosts() throws DaoException;
	
	public List<Post> selectPostsByCategory(Integer idCategory) throws DaoException;
	
	public List<Post> selectPostsByCategoryBySubcategory(Integer idCategory, Integer idSubcategory) throws DaoException;

	public void deletePost(Integer idPost) throws DaoException;
	
	public Post selectPost(Integer idPost) throws DaoException;
	
	public Post selectPostWithoutAll(Integer idPost) throws DaoException;
	
	public int countPostByDesigner(Integer idUser) throws DaoException;
	
	public List<Post> selectPostsByModeratingForSort() throws DaoException;
	
	public List<Post> selectPostsByRejectingForSort() throws DaoException;
	
	public List<Post> selectTop4ByLike() throws DaoException;

	public List<Post> selectComplainedPostsForSort() throws DaoException;
	
	public Map<Integer, Integer> selectColPostsForAllUsers() throws DaoException;

	public List<Integer> selectIdDesignersHavePosts() throws DaoException;
}
