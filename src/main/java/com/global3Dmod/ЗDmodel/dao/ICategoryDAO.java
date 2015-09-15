package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.Category;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface ICategoryDAO {
	
	public void updateCategory(Category category) throws DaoException;

	public void insertCategory(Category category) throws DaoException;

	public List<Category> selectAllCategories() throws DaoException;
	
	public List<Category> selectAllCategoriesWithSubcategories() throws DaoException;

	public void deleteCategory(Integer id) throws DaoException;

	public Category selectCategoryById(int idCategory) throws DaoException;
}
