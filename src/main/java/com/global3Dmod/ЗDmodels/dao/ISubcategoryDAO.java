package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Subcategory;

public interface ISubcategoryDAO {
	
	public void update(Subcategory subcategory);

	public void add(Subcategory subcategory);

	public List<Subcategory> getAllSubcategories();

	public void remove(Integer id);

}
