package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.ÇDmodels.dao.IVotecheckDAO;
import com.global3Dmod.ÇDmodels.domain.Votecheck;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaVotecheckDAO")
@Transactional
public class VotecheckDAOImpl implements IVotecheckDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Votecheck" to the database
	 * @param votecheck object of type "Votecheck"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void insertVotecheck(Votecheck votecheck) throws DaoException {
		em.persist(votecheck);

	}

	/**
	 * Receipt of all elements of the table "votechecks" from the database
	 * @return votecheck collection of objects of type "Votecheck"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@AspectDaoG3DM
	public List<Votecheck> selectAllVotechecks() throws DaoException {
		List<Votecheck> votecheck = em.createNamedQuery("Votecheck.findAll").getResultList();
		return votecheck;
	}

	/**
	 * Delete the object of type "Votecheck" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void deleteVotecheck(Integer id) throws DaoException {
		Votecheck votecheck = em.find(Votecheck.class, id);
		em.remove(votecheck);
	}

	/**
	 * Update the object of type "Votecheck" in the database
	 * @param votecheck object of type "Votecheck"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void updateVotecheck(Votecheck votecheck) throws DaoException {
		em.merge(votecheck);
		
	}

}
