package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Rating;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IRatingDAO {
	
	public void update(Rating rating) throws DaoException;

	public void add(Rating rating) throws DaoException;
	
	public List<Rating> getAllRatings() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
