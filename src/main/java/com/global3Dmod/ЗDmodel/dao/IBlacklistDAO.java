package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.Blacklist;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface IBlacklistDAO {

	public void updateBlacklist(Blacklist blacklist) throws DaoException;

	public void insertBlacklist(Blacklist blacklist) throws DaoException;

	public List<Blacklist> selectAllBlacklists() throws DaoException;

	public void deleteBlacklist(Integer id) throws DaoException;

	public List<Blacklist> selectBlacklistByIdUser(int idUser) throws DaoException;
}
