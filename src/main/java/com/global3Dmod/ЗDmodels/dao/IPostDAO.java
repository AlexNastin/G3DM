package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IPostDAO {
	
	public void update(Post post) throws DaoException;

	public void add(Post post) throws DaoException;

	public List<Post> getAllPosts() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
