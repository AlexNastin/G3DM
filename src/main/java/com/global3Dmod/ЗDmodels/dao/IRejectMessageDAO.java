package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Comment;
import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.domain.RejectMessage;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IRejectMessageDAO {
	
	public void updateRejectMessage(RejectMessage rejectMessage) throws DaoException;

	public void insertRejectMessage(RejectMessage rejectMessage) throws DaoException;

	public List<RejectMessage> selectAllRejectMessages() throws DaoException;

	public void deleteRejectMessage(Integer id) throws DaoException;
	
	public RejectMessage selectRejectMessageByPost(Integer idPost) throws DaoException;

}
