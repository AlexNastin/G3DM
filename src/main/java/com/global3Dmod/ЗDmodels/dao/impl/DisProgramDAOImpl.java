package com.global3Dmod.�Dmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodels.dao.IDisProgramDAO;
import com.global3Dmod.�Dmodels.domain.DisProgram;
import com.global3Dmod.�Dmodels.exception.DaoException;


@Repository("jpaDisProgramDAO")
@Transactional
public class DisProgramDAOImpl implements IDisProgramDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertDisProgram(DisProgram disProgram) throws DaoException {
		em.persist(disProgram);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisProgram> selectAllDisPrograms() throws DaoException {
		List<DisProgram> disProgram = em.createNamedQuery("DisProgram.findAll").getResultList();
		return disProgram;
	}

	@Override
	@Transactional
	public void deleteDisProgram(Integer id) throws DaoException {
		DisProgram disProgram = em.find(DisProgram.class, id);
		em.remove(disProgram);
	}

	@Override
	@Transactional
	public void updateDisProgram(DisProgram disProgram) throws DaoException {
		em.merge(disProgram);
		
	}

}
