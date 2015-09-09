package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IDisProgramDAO;
import com.global3Dmod.ÇDmodels.domain.DisProgram;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaDisProgramDAO")
public class DisProgramDAOImpl implements IDisProgramDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "DisProgram" to the database
	 * @param disProgram object of type "DisProgram"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertDisProgram(DisProgram disProgram) throws DaoException {
		em.persist(disProgram);

	}

	/**
	 * Receipt of all elements of the table "disprograms" from the database
	 * @return disProgram collection of objects of type "DisProgram"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<DisProgram> selectAllDisPrograms() throws DaoException {
		List<DisProgram> disProgram = em.createNamedQuery("DisProgram.findAll").getResultList();
		return disProgram;
	}

	/**
	 * Delete the object of type "DisProgram" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteDisProgram(Integer id) throws DaoException {
		DisProgram disProgram = em.find(DisProgram.class, id);
		em.remove(disProgram);
	}

	/**
	 * Update the object of type "DisProgram" in the database
	 * @param disProgram object of type "DisProgram"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateDisProgram(DisProgram disProgram) throws DaoException {
		em.merge(disProgram);
		
	}

}
