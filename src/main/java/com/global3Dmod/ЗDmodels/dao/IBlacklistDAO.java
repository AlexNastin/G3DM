package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Blacklist;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IBlacklistDAO {
	
	public void update(Blacklist blacklist) throws DaoException;

	public void add(Blacklist blacklist) throws DaoException;

	public List<Blacklist> getAllBlacklists() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
