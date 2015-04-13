package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Comment;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface ICommentDAO {
	
	public void update(Comment comment) throws DaoException;

	public void add(Comment comment) throws DaoException;

	public List<Comment> getAllComments() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
