package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Rating;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IRatingDAO {
	
	public void updateRating(Rating rating) throws DaoException;

	public void insertRating(Rating rating) throws DaoException;
	
	public List<Rating> selectAllRatings() throws DaoException;

	public void deleteRating(Integer id) throws DaoException;

}
