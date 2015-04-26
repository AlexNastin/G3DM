package com.global3Dmod.�Dmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.�Dmodels.dao.ICategoryDAO;
import com.global3Dmod.�Dmodels.domain.Category;
import com.global3Dmod.�Dmodels.exception.DaoException;


@Repository("jpaCategoryDAO")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Category" to the database
	 * @param category object of type "Category"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void insertCategory(Category category) throws DaoException {
		em.persist(category);

	}

	/**
	 * Receipt of all elements of the table "categories" from the database
	 * @return category collection of objects of type "Category"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@AspectDaoG3DM
	public List<Category> selectAllCategories() throws DaoException {
		List<Category> category = em.createNamedQuery("Category.findAll").getResultList();
		return category;
	}

	/**
	 * Delete the object of type "Category" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void deleteCategory(Integer id) throws DaoException  {
		Category category = em.find(Category.class, id);
		em.remove(category);
	}

	/**
	 * Update the object of type "Category" in the database
	 * @param category object of type "Category"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void updateCategory(Category category) throws DaoException {
		em.merge(category);
		
	}

}
