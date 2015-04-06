package com.global3Dmod.printer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.printer.dao.ICategoryDAO;
import com.global3Dmod.printer.domain.Category;

@Component
@Repository("jpaCategoryDAO")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Category category) {
		em.persist(category);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Category> getAllCategories() {
		List<Category> category = em.createNamedQuery("Category.findAll").getResultList();
		return category;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Category category = em.find(Category.class, id);
		em.remove(category);
	}

	@Override
	@Transactional
	public void update(Category category) {
		em.merge(category);
		
	}

}
