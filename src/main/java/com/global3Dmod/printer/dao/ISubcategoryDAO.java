package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.Subcategory;

public interface ISubcategoryDAO {
	
	public void update(Subcategory subcategory);

	public void add(Subcategory subcategory);

	public List<Subcategory> getAllSubcategories();

	public void remove(Integer id);

}
