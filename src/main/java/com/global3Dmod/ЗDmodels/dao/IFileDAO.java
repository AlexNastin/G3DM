package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.File;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IFileDAO {

	public void update(File file) throws DaoException;

	public void add(File file) throws DaoException;

	public List<File> getAllFiles() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
