package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.ÇDmodels.dao.ICityDAO;
import com.global3Dmod.ÇDmodels.domain.City;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaCityDAO")
@Transactional
public class CityDAOImpl implements ICityDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "City" to the database
	 * @param city object of type "City"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void insertCity(City city) throws DaoException {
		em.persist(city);

	}

	/**
	 * Receipt of all elements of the table "cities" from the database
	 * @return cities collection of objects of type "City"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@AspectDaoG3DM
	public List<City> selectAllCities() throws DaoException {
		List<City> cities = em.createNamedQuery("City.findAll").getResultList();
		return cities;
	}

	/**
	 * Delete the object of type "City" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void deleteCity(Integer id) throws DaoException {
		City city = em.find(City.class, id);
		em.remove(city);
	}

	/**
	 * Update the object of type "City" in the database
	 * @param city object of type "City"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void updateCity(City city) throws DaoException {
		em.merge(city);
		
	}

}
