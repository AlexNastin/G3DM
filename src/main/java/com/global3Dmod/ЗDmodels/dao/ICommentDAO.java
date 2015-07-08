package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Comment;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface ICommentDAO {
	
	public void updateComment(Comment comment) throws DaoException;

	public void insertComment(Comment comment) throws DaoException;

	public List<Comment> selectAllComments() throws DaoException;

	public void deleteComment(Integer id) throws DaoException;
	
	public List<Comment> selectCommentsByPost(Integer idPost) throws DaoException;

}
