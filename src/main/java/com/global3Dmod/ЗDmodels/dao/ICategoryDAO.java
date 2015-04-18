package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface ICategoryDAO {
	
	public void updateCategory(Category category) throws DaoException;

	public void insertCategory(Category category) throws DaoException;

	public List<Category> selectAllCategories() throws DaoException;

	public void deleteCategory(Integer id) throws DaoException;

}
