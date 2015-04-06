package com.global3Dmod.printer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.printer.dao.ICityDAO;
import com.global3Dmod.printer.domain.City;

@Component
@Repository("jpaCityDAO")
@Transactional
public class CityDAOImpl implements ICityDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(City city) {
		em.persist(city);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<City> getAllCities() {
		List<City> cities = em.createNamedQuery("City.findAll").getResultList();
		return cities;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		City city = em.find(City.class, id);
		em.remove(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		em.merge(city);
		
	}

}
