package com.global3Dmod.printer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.printer.dao.ICountryDAO;
import com.global3Dmod.printer.domain.Country;

@Component
@Repository("jpaCountryDAO")
@Transactional
public class ICountryDAOImpl implements ICountryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Country country) {
		em.persist(country);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Country> getAllCountries() {
		List<Country> country = em.createNamedQuery("Country.findAll").getResultList();
		return country;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Country country = em.find(Country.class, id);
		em.remove(country);
	}

	@Override
	@Transactional
	public void update(Country country) {
		em.merge(country);
		
	}

}
