package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.File;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IFileDAO {

	public void updateFile(File file) throws DaoException;

	public void insertFile(File file) throws DaoException;

	public List<File> selectAllFiles() throws DaoException;

	public void deleteFile(Integer id) throws DaoException;

}
