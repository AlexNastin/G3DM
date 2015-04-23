package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IBlacklistDAO;
import com.global3Dmod.ÇDmodels.domain.Blacklist;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaBlacklistDAO")
@Transactional
public class BlacklistDAOImpl implements IBlacklistDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the blacklist to the database
	 * @param blacklist object of type "Blacklist"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertBlacklist(Blacklist blacklist) throws DaoException {
		em.persist(blacklist);

	}

	/**
	 * Receipt of all elements of the table "blacklist" from the database
	 * @return blacklist collection of objects of type "Blacklist"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Blacklist> selectAllBlacklists() throws DaoException {
		List<Blacklist> blacklist = em.createNamedQuery("Blacklist.findAll").getResultList();
		return blacklist;
	}

	/**
	 * Delete the blacklist from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteBlacklist(Integer id) throws DaoException {
		Blacklist blacklist = em.find(Blacklist.class, id);
		em.remove(blacklist);
	}

	/**
	 * Update the blacklist in the database
	 * @param blacklist object of type "Blacklist"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateBlacklist(Blacklist blacklist) throws DaoException {
		em.merge(blacklist);
		
	}

}
