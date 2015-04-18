package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.DisProgram;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IDisProgramDAO {
	
	public void updateDisProgram(DisProgram disProgram) throws DaoException;

	public void insertDisProgram(DisProgram disProgram) throws DaoException;

	public List<DisProgram> selectAllDisPrograms() throws DaoException;

	public void deleteDisProgram(Integer id) throws DaoException;

}
