package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.City;

public interface ICityDAO {
	
	public void update(City city);

	public void add(City city);

	public List<City> getAllCities();

	public void remove(Integer id);

}
