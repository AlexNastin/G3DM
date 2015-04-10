package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Rating;

public interface IRatingDAO {
	
	public void update(Rating rating);

	public void add(Rating rating);

	public List<Rating> getAllRatings();

	public void remove(Integer id);

}
