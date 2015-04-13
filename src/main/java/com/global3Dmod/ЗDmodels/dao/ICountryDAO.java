package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Country;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface ICountryDAO {
	
	public void update(Country country) throws DaoException;

	public void add(Country country) throws DaoException;

	public List<Country> getAllCountries() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
