package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.RejectMessage;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IRejectMessageDAO {
	
	public void updateRejectMessage(RejectMessage rejectMessage) throws DaoException;

	public void insertRejectMessage(RejectMessage rejectMessage) throws DaoException;

	public List<RejectMessage> selectAllRejectMessages() throws DaoException;

	public void deleteRejectMessage(Integer id) throws DaoException;
	
	public RejectMessage selectRejectMessageByPost(Integer idPost) throws DaoException;

}
