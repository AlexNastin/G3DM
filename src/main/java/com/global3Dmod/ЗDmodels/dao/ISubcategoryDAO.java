package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Subcategory;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface ISubcategoryDAO {

	public void update(Subcategory subcategory) throws DaoException;

	public void add(Subcategory subcategory) throws DaoException;

	public List<Subcategory> getAllSubcategories() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
