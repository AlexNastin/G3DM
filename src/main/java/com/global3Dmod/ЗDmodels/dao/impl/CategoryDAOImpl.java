package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ICategoryDAO;
import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaCategoryDAO")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Ïðîñòîå îïèñàíèå ìåòîäà
	 * 
	 * 
	 * @param category
	 * @return void
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertCategory(Category category) throws DaoException { //Exeption
		em.persist(category);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Category> selectAllCategories() {
	
	
		List<Category> category = em.createNamedQuery("Category.findAll").getResultList();
		return category;
	}

	@Override
	@Transactional
	public void deleteCategory(Integer id)  {
		Category category = em.find(Category.class, id);
		em.remove(category);
	}

	@Override
	@Transactional
	public void updateCategory(Category category) {
		em.merge(category);
		
	}

}
