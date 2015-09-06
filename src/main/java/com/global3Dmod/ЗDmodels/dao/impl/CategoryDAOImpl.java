package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ICategoryDAO;
import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.exception.DaoException;

@Repository("jpaCategoryDAO")
public class CategoryDAOImpl implements ICategoryDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Category" to the database
	 * 
	 * @param category
	 *            object of type "Category"
	 * @throws DaoException
	 * */
	@Override
	public void insertCategory(Category category) throws DaoException {
		em.persist(category);

	}

	/**
	 * Receipt of all elements of the table "categories" from the database
	 * 
	 * @return category collection of objects of type "Category"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> selectAllCategories() throws DaoException {
		List<Category> categories = em.createNamedQuery("Category.findAll").getResultList();
		return categories;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Category> selectAllCategoriesWithSubcategories()
			throws DaoException {
		List<Category> categories = em.createNamedQuery("Category.findAll").getResultList();
		for (Category category : categories) {
			Hibernate.initialize(category.getSubcategories());
		}
		return categories;
	}

	/**
	 * Delete the object of type "Category" from the database
	 * 
	 * @param id
	 *            row ID in the database
	 * @throws DaoException
	 * */
	@Override
	public void deleteCategory(Integer id) throws DaoException {
		Category category = em.find(Category.class, id);
		em.remove(category);
	}

	/**
	 * Update the object of type "Category" in the database
	 * 
	 * @param category
	 *            object of type "Category"
	 * @throws DaoException
	 * */
	@Override
	public void updateCategory(Category category) throws DaoException {
		em.merge(category);

	}

	@Override
	public Category selectCategoryById(int idCategory) throws DaoException {
		Category category = (Category) em
				.createNamedQuery("Category.findCategoryById")
				.setParameter("idCategory", idCategory).getSingleResult();
		return category;

	}
}
