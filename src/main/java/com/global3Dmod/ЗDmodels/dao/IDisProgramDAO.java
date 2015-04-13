package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.DisProgram;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IDisProgramDAO {
	
	public void update(DisProgram disProgram) throws DaoException;

	public void add(DisProgram disProgram) throws DaoException;

	public List<DisProgram> getAllDisPrograms() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
