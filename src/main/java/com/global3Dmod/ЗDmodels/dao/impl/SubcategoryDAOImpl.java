package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ISubcategoryDAO;
import com.global3Dmod.ÇDmodels.domain.Subcategory;

@Component
@Repository("jpaSubcategoryDAO")
@Transactional
public class SubcategoryDAOImpl implements ISubcategoryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Subcategory subcategory) {
		em.persist(subcategory);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Subcategory> getAllSubcategories() {
		List<Subcategory> subcategory = em.createNamedQuery("Subcategory.findAll").getResultList();
		return subcategory;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Subcategory subcategory = em.find(Subcategory.class, id);
		em.remove(subcategory);
	}

	@Override
	@Transactional
	public void update(Subcategory subcategory) {
		em.merge(subcategory);
		
	}

}
