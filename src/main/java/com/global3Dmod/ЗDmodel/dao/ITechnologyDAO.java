package com.global3Dmod.ÇDmodel.dao;

import java.util.List;

import com.global3Dmod.ÇDmodel.domain.Technology;
import com.global3Dmod.ÇDmodel.exception.DaoException;

public interface ITechnologyDAO {

	public void updateTechnolog(Technology technology) throws DaoException;

	public void insertTechnology(Technology technology) throws DaoException;

	public List<Technology> selectAllTechnologies() throws DaoException;
	
	public List<Technology> selectCheckTechnologiesById(String [] printersId) throws DaoException;

	public void deleteTechnology(Integer idTechnology) throws DaoException;

}
