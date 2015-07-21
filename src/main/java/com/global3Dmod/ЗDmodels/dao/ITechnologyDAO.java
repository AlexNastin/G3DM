package com.global3Dmod.ÇDmodels.dao;

import java.util.List;
import java.util.Set;

import com.global3Dmod.ÇDmodels.domain.Technology;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface ITechnologyDAO {

	public void updateTechnolog(Technology technology) throws DaoException;

	public void insertTechnology(Technology technology) throws DaoException;

	public List<Technology> selectAllTechnologies() throws DaoException;
	
	public List<Technology> selectCheckTechnologiesById(String [] printersId) throws DaoException;

	public void deleteTechnology(Integer idTechnology) throws DaoException;

}
