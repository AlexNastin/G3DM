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
public class CountryDAOImpl implements ICountryDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Country" to the database
	 * @param country object of type "Country"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertCountry(Country country) throws DaoException {
		em.persist(country);

	}

	/**
	 * Receipt of all elements of the table "countries" from the database
	 * @return country collection of objects of type "Country"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> selectAllCountries() throws DaoException {
		List<Country> country = em.createNamedQuery("Country.findAll").getResultList();
		return country;
	}

	/**
	 * Delete the object of type "Country" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteCountry(Integer id) throws DaoException {
		Country country = em.find(Country.class, id);
		em.remove(country);
	}

	/**
	 * Update the object of type "Country" in the database
	 * @param country object of type "Country"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateCountry(Country country) throws DaoException {
		em.merge(country);
		
	}

	@Override
	public Country selectCountryById(int idCountry) throws DaoException {
		Country country = (Country) em.createNamedQuery("Country.findCountryById").setParameter("idCountry", idCountry).getSingleResult();
		return country;
	}

}
