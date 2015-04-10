package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IRatingDAO;
import com.global3Dmod.ÇDmodels.domain.Rating;

@Component
@Repository("jpaRatingDAO")
@Transactional
public class RatingDAOImpl implements IRatingDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Rating rating) {
		em.persist(rating);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rating> getAllRatings() {
		List<Rating> rating = em.createNamedQuery("Rating.findAll").getResultList();
		return rating;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Rating rating = em.find(Rating.class, id);
		em.remove(rating);
	}

	@Override
	@Transactional
	public void update(Rating rating) {
		em.merge(rating);
		
	}

}
