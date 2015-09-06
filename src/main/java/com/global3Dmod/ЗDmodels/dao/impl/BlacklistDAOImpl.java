package com.global3Dmod.�Dmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.global3Dmod.�Dmodels.dao.IBlacklistDAO;
import com.global3Dmod.�Dmodels.domain.Blacklist;
import com.global3Dmod.�Dmodels.exception.DaoException;


@Repository("jpaBlacklistDAO")
public class BlacklistDAOImpl implements IBlacklistDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Blacklist" to the database
	 * @param blacklist object of type "Blacklist"
	 * @throws DaoException
	 * */
	@Override
	public void insertBlacklist(Blacklist blacklist) throws DaoException {
		em.persist(blacklist);

	}

	/**
	 * Receipt of all elements of the table "blacklists" from the database
	 * @return blacklist collection of objects of type "Blacklist"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Blacklist> selectAllBlacklists() throws DaoException {
		List<Blacklist> blacklist = em.createNamedQuery("Blacklist.findAll").getResultList();
		return blacklist;
	}

	/**
	 * Delete the object of type "Blacklist" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	public void deleteBlacklist(Integer id) throws DaoException {
		Blacklist blacklist = em.find(Blacklist.class, id);
		em.remove(blacklist);
	}

	/**
	 * Update the object of type "Blacklist" in the database
	 * @param blacklist object of type "Blacklist"
	 * @throws DaoException
	 * */
	@Override
	public void updateBlacklist(Blacklist blacklist) throws DaoException {
		em.merge(blacklist);
		
	}

}
