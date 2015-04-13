package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Blacklist;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IBlacklistDAO {
	
	public void update(Blacklist blacklist) throws DaoException;

	public void add(Blacklist blacklist) throws DaoException;

	public List<Blacklist> getAllBlacklists() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
