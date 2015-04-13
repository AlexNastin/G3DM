package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Subcategory;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface ISubcategoryDAO {

	public void update(Subcategory subcategory) throws DaoException;

	public void add(Subcategory subcategory) throws DaoException;

	public List<Subcategory> getAllSubcategories() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
