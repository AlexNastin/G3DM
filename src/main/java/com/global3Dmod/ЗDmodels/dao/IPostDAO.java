package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IPostDAO {
	
	public void updatePost(Post post) throws DaoException;

	public void insertPost(Post post) throws DaoException;

	public List<Post> selectAllPosts() throws DaoException;
	
	public List<Post> selectPostsByDesigner(Integer idDesigner) throws DaoException;
	
	public List<Post> selectPostsByDesignerForSort(Integer idDesigner) throws DaoException;
	
	public List<Post> selectPostsByUserForSort(Integer idDesigner) throws DaoException;
	
	public List<Post> selectPostsLimit10(Integer page) throws DaoException;
	
	public List<Post> selectPostsLimit10ByCategory(Integer page, Integer idCategory) throws DaoException;
	
	public List<Post> selectPostsLimit10BySubcategory(Integer page, Integer idCategory, Integer idSubcategory) throws DaoException;

	public void deletePost(Integer idPost) throws DaoException;
	
	public Post selectPost(Integer idPost) throws DaoException;
	
	public Post selectPostForDelete(Integer idPost) throws DaoException;
	
	public int countPostByDesigner(Integer idUser) throws DaoException;
	
	public List<Post> selectPostsByModeratingForSort() throws DaoException;

}
