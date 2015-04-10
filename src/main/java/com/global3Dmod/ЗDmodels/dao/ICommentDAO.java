package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Comment;

public interface ICommentDAO {
	
	public void update(Comment comment);

	public void add(Comment comment);

	public List<Comment> getAllComments();

	public void remove(Integer id);

}
