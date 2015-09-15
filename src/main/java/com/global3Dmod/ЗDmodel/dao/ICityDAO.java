package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.City;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface ICityDAO {
	
	public void updateCity(City city) throws DaoException;

	public void insertCity(City city) throws DaoException;

	public List<City> selectAllCities() throws DaoException;

	public void deleteCity(Integer id) throws DaoException;

}
