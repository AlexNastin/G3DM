package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.ÇDmodels.dao.IRatingDAO;
import com.global3Dmod.ÇDmodels.domain.Rating;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaRatingDAO")
@Transactional
public class RatingDAOImpl implements IRatingDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Rating" to the database
	 * @param rating object of type "Rating"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void insertRating(Rating rating) throws DaoException {
		em.persist(rating);

	}

	/**
	 * Receipt of all elements of the table "ratings" from the database
	 * @return rating collection of objects of type "Rating"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@AspectDaoG3DM
	public List<Rating> selectAllRatings() throws DaoException {
		List<Rating> rating = em.createNamedQuery("Rating.findAll").getResultList();
		return rating;
	}

	/**
	 * Delete the object of type "Rating" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void deleteRating(Integer id) throws DaoException {
		Rating rating = em.find(Rating.class, id);
		em.remove(rating);
	}

	/**
	 * Update the object of type "Rating" in the database
	 * @param rating object of type "Rating"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void updateRating(Rating rating) throws DaoException {
		em.merge(rating);
		
	}

}
