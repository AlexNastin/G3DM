package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.ÇDmodels.dao.ISubcategoryDAO;
import com.global3Dmod.ÇDmodels.domain.Subcategory;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaSubcategoryDAO")
@Transactional
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
	@AspectDaoG3DM
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
	@Transactional
	@AspectDaoG3DM
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
	@AspectDaoG3DM
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
	@AspectDaoG3DM
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
	@Transactional
	@AspectDaoG3DM
	public List<Subcategory> selectTop3Subcategories(Integer id) throws DaoException {
		List<Subcategory> subcategoriesTop = em.createNamedQuery("Subcategory.findTop3").setParameter("idCategory", id)
				.setFirstResult(0).setMaxResults(3).getResultList();
		return subcategoriesTop;
	}

}
