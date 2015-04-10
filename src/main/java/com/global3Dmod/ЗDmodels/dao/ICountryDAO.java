package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Country;

public interface ICountryDAO {
	
	public void update(Country country);

	public void add(Country country);

	public List<Country> getAllCountries();

	public void remove(Integer id);

}
