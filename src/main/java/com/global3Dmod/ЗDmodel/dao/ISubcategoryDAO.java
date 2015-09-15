package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.Subcategory;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface ISubcategoryDAO {

	public void updateSubcategory(Subcategory subcategory) throws DaoException;

	public void insertSubcategory(Subcategory subcategory) throws DaoException;

	public List<Subcategory> selectAllSubcategories() throws DaoException;

	public void deleteSubcategory(Integer id) throws DaoException;
	
	public List<Subcategory> selectTop3Subcategories(Integer id) throws DaoException;

}
