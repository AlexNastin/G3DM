package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ICityDAO;
import com.global3Dmod.ÇDmodels.domain.City;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaCityDAO")
@Transactional
public class CityDAOImpl implements ICityDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertCity(City city) throws DaoException {
		em.persist(city);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<City> selectAllCities() throws DaoException {
		List<City> cities = em.createNamedQuery("City.findAll").getResultList();
		return cities;
	}

	@Override
	@Transactional
	public void deleteCity(Integer id) throws DaoException {
		City city = em.find(City.class, id);
		em.remove(city);
	}

	@Override
	@Transactional
	public void updateCity(City city) throws DaoException {
		em.merge(city);
		
	}

}
