package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface ICategoryDAO {
	
	public void update(Category category) throws DaoException;

	public void add(Category category) throws DaoException;

	public List<Category> getAllCategories() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
