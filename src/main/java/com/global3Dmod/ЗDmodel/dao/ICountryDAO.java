package com.global3Dmod.ÇDmodel.dao;

import java.util.List;

import com.global3Dmod.ÇDmodel.domain.Country;
import com.global3Dmod.ÇDmodel.exception.DaoException;

public interface ICountryDAO {
	
	public void updateCountry(Country country) throws DaoException;

	public void insertCountry(Country country) throws DaoException;

	public List<Country> selectAllCountries() throws DaoException;

	public void deleteCountry(Integer id) throws DaoException;
	
	public Country selectCountryById(int idCountry) throws DaoException;

}
