package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.File;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IFileDAO {

	public void update(File file) throws DaoException;

	public void add(File file) throws DaoException;

	public List<File> getAllFiles() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
