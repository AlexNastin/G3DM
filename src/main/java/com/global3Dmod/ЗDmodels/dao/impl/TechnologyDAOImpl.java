package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.global3Dmod.ÇDmodels.dao.ITechnologyDAO;
import com.global3Dmod.ÇDmodels.domain.Technology;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaTechnologyDAO")
public class TechnologyDAOImpl implements ITechnologyDAO {
	
	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Technology" to the database
	 * @param printer object of type "Technology"
	 * @throws DaoException
	 * */
	@Override
	public void insertTechnology(Technology technology) throws DaoException {
		em.persist(technology);

	}

	/**
	 * Receipt of all elements of the table "technologies" from the database
	 * @return printer collection of objects of type "Technology"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Technology> selectAllTechnologies() throws DaoException {
		List<Technology> printer = em.createNamedQuery("Technology.findAll").getResultList();
		return printer;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Technology> selectCheckTechnologiesById(String [] technologiesId) throws DaoException {
		List<Integer> listIdTechnology = new ArrayList<Integer>();
		for (String technologyId : technologiesId) {
			listIdTechnology.add(Integer.parseInt(technologyId));
		}
		List<Technology> printer = em.createNamedQuery("Technology.findCheckById").setParameter("idTechnology", listIdTechnology).getResultList();
		return printer;
	}

	/**
	 * Delete the object of type "Technology" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	public void deleteTechnology(Integer id) throws DaoException {
		Technology printer = em.find(Technology.class, id);
		em.remove(printer);
	}

	/**
	 * Update the object of type "Technology" in the database
	 * @param printer object of type "Technology"
	 * @throws DaoException
	 * */
	@Override
	public void updateTechnolog(Technology printer) throws DaoException {
		em.merge(printer);
		
	}

}
