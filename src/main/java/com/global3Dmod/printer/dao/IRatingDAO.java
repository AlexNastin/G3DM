package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.Rating;

public interface IRatingDAO {
	
	public void update(Rating rating);

	public void add(Rating rating);

	public List<Rating> getAllRatings();

	public void remove(Integer id);

}
