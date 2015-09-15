package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.DisProgram;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface IDisProgramDAO {
	
	public void updateDisProgram(DisProgram disProgram) throws DaoException;

	public void insertDisProgram(DisProgram disProgram) throws DaoException;

	public List<DisProgram> selectAllDisPrograms() throws DaoException;

	public void deleteDisProgram(Integer id) throws DaoException;

}
