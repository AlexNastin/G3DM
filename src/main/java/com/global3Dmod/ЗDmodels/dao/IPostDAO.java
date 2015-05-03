package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IPostDAO {
	
	public void updatePost(Post post) throws DaoException;

	public void insertPost(Post post) throws DaoException;

	public List<Post> selectAllPosts() throws DaoException;
	
	public List<Post> selectPostsByDesigner(Integer id) throws DaoException;

	public void deletePost(Integer id) throws DaoException;

}
