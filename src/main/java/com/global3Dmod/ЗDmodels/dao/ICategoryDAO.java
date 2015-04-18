package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface ICategoryDAO {
	
	public void updateCategory(Category category) throws DaoException;

	public void insertCategory(Category category) throws DaoException;

	public List<Category> selectAllCategories() throws DaoException;

	public void deleteCategory(Integer id) throws DaoException;

}
