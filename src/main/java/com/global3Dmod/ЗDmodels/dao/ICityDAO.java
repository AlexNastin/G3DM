package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.City;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface ICityDAO {
	
	public void update(City city) throws DaoException;

	public void add(City city) throws DaoException;

	public List<City> getAllCities() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
