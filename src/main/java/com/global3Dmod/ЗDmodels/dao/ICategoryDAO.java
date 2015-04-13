package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface ICategoryDAO {
	
	public void update(Category category) throws DaoException;

	public void add(Category category) throws DaoException;

	public List<Category> getAllCategories() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
