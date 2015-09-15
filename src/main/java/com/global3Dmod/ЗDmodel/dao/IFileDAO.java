package com.global3Dmod.ÇDmodel.dao;

import java.util.List;

import com.global3Dmod.ÇDmodel.domain.File;
import com.global3Dmod.ÇDmodel.exception.DaoException;

public interface IFileDAO {

	public void updateFile(File file) throws DaoException;

	public void insertFile(File file) throws DaoException;

	public List<File> selectAllFiles() throws DaoException;

	public void deleteFile(Integer id) throws DaoException;
	
	public File selectFileById(Integer idFile) throws DaoException;

}
