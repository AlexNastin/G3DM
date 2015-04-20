package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IVotecheckDAO;
import com.global3Dmod.ÇDmodels.domain.Votecheck;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaVotecheckDAO")
@Transactional
public class VotecheckDAOImpl implements IVotecheckDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertVotecheck(Votecheck votecheck) throws DaoException {
		em.persist(votecheck);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Votecheck> selectAllVotechecks() throws DaoException {
		List<Votecheck> votecheck = em.createNamedQuery("Votecheck.findAll").getResultList();
		return votecheck;
	}

	@Override
	@Transactional
	public void deleteVotecheck(Integer id) throws DaoException {
		Votecheck votecheck = em.find(Votecheck.class, id);
		em.remove(votecheck);
	}

	@Override
	@Transactional
	public void updateVotecheck(Votecheck votecheck) throws DaoException {
		em.merge(votecheck);
		
	}

}
