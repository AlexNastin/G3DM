package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Votecheck;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IVotecheckDAO {
	
	public void updateVotecheck(Votecheck votecheck) throws DaoException;

	public void insertVotecheck(Votecheck votecheck) throws DaoException;

	public List<Votecheck> selectAllVotechecks() throws DaoException;

	public void deleteVotecheck(Integer id) throws DaoException;
}
