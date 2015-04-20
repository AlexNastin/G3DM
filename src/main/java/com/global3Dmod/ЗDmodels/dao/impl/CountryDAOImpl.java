package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ICountryDAO;
import com.global3Dmod.ÇDmodels.domain.Country;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaCountryDAO")
@Transactional
public class CountryDAOImpl implements ICountryDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertCountry(Country country) throws DaoException {
		em.persist(country);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Country> selectAllCountries() throws DaoException {
		List<Country> country = em.createNamedQuery("Country.findAll").getResultList();
		return country;
	}

	@Override
	@Transactional
	public void deleteCountry(Integer id) throws DaoException {
		Country country = em.find(Country.class, id);
		em.remove(country);
	}

	@Override
	@Transactional
	public void updateCountry(Country country) throws DaoException {
		em.merge(country);
		
	}

}
