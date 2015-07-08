package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Comment;
import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface ICommentDAO {
	
	public void updateComment(Comment comment) throws DaoException;

	public void insertComment(Comment comment) throws DaoException;

	public List<Comment> selectAllComments() throws DaoException;

	public void deleteComment(Integer id) throws DaoException;
	
	public List<Comment> selectCommentsByPost(Integer idPost) throws DaoException;

}
