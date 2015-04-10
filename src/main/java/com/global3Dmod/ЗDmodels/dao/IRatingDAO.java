package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Rating;

public interface IRatingDAO {
	
	public void update(Rating rating);

	public void add(Rating rating);

	public List<Rating> getAllRatings();

	public void remove(Integer id);

}
