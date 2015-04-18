package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IRatingDAO;
import com.global3Dmod.ÇDmodels.domain.Rating;


@Repository("jpaRatingDAO")
@Transactional
public class RatingDAOImpl implements IRatingDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertRating(Rating rating) {
		em.persist(rating);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rating> selectAllRatings() {
		List<Rating> rating = em.createNamedQuery("Rating.findAll").getResultList();
		return rating;
	}

	@Override
	@Transactional
	public void deleteRating(Integer id) {
		Rating rating = em.find(Rating.class, id);
		em.remove(rating);
	}

	@Override
	@Transactional
	public void updateRating(Rating rating) {
		em.merge(rating);
		
	}

}
