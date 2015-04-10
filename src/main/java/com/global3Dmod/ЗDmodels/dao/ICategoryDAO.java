package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Category;

public interface ICategoryDAO {
	
	public void update(Category category);

	public void add(Category category);

	public List<Category> getAllCategories();

	public void remove(Integer id);

}
