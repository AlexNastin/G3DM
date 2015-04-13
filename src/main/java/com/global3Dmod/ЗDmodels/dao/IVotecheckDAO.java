package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Votecheck;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IVotecheckDAO {
	
	public void update(Votecheck votecheck) throws DaoException;

	public void add(Votecheck votecheck) throws DaoException;

	public List<Votecheck> getAllVotechecks() throws DaoException;

	public void remove(Integer id) throws DaoException;
}
