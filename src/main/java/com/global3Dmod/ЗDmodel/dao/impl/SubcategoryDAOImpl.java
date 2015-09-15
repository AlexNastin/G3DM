package com.global3Dmod.ÇDmodel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodel.dao.ISubcategoryDAO;
import com.global3Dmod.ÇDmodel.domain.Subcategory;
import com.global3Dmod.ÇDmodel.exception.DaoException;


@Repository("jpaSubcategoryDAO")
public class SubcategoryDAOImpl implements ISubcategoryDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Subcategory" to the database
	 * @param subcategory object of type "Subcategory"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertSubcategory(Subcategory subcategory) throws DaoException {
		em.persist(subcategory);

	}

	/**
	 * Receipt of all elements of the table "subcategories" from the database
	 * @return subcategory collection of objects of type "Subcategory"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subcategory> selectAllSubcategories() throws DaoException {
		List<Subcategory> subcategory = em.createNamedQuery("Subcategory.findAll").getResultList();
		return subcategory;
	}

	/**
	 * Delete the object of type "Subcategory" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteSubcategory(Integer id) throws DaoException {
		Subcategory subcategory = em.find(Subcategory.class, id);
		em.remove(subcategory);
	}

	/**
	 * Update the object of type "Subcategory" in the database
	 * @param subcategory object of type "Subcategory"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateSubcategory(Subcategory subcategory) throws DaoException {
		em.merge(subcategory);
		
	}

	/**
	 * Receipt of 3 elements of the table "subcategories" from the database
	 * @return subcategoriesTop collection of objects of type "Subcategory"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subcategory> selectTop3Subcategories(Integer id) throws DaoException {
		List<Subcategory> subcategoriesTop = em.createNamedQuery("Subcategory.findTop3").setParameter("idCategory", id)
				.setFirstResult(0).setMaxResults(3).getResultList();
		return subcategoriesTop;
	}

}
