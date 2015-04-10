package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Votecheck;

public interface IVotecheckDAO {
	
	public void update(Votecheck votecheck);

	public void add(Votecheck votecheck);

	public List<Votecheck> getAllVotechecks();

	public void remove(Integer id);

}
