package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IDisProgramDAO;
import com.global3Dmod.ÇDmodels.domain.DisProgram;

@Component
@Repository("jpaDisProgramDAO")
@Transactional
public class DisProgramDAOImpl implements IDisProgramDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(DisProgram disProgram) {
		em.persist(disProgram);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DisProgram> getAllDisPrograms() {
		List<DisProgram> disProgram = em.createNamedQuery("DisProgram.findAll").getResultList();
		return disProgram;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		DisProgram disProgram = em.find(DisProgram.class, id);
		em.remove(disProgram);
	}

	@Override
	@Transactional
	public void update(DisProgram disProgram) {
		em.merge(disProgram);
		
	}

}
