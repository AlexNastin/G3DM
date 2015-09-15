package com.global3Dmod.�Dmodel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodel.dao.IBlacklistDAO;
import com.global3Dmod.�Dmodel.domain.Blacklist;
import com.global3Dmod.�Dmodel.exception.DaoException;

@Repository("jpaBlacklistDAO")
public class BlacklistDAOImpl implements IBlacklistDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Blacklist" to the database
	 * 
	 * @param blacklist
	 *            object of type "Blacklist"
	 * @throws DaoException
	 */
	@Override
	@Transactional
	public void insertBlacklist(Blacklist blacklist) throws DaoException {
		em.persist(blacklist);

	}

	/**
	 * 
	 * Finds the object of type "Blacklist" to the database by id user
	 * 
	 * @param blacklist
	 *            object of type "Blacklist"
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Blacklist> selectBlacklistByIdUser(int idUser) throws DaoException {
		List<Blacklist> blacklist = em.createNamedQuery("Blacklist.findBlacklistByIdUser")
				.setParameter("user_idUser", idUser).getResultList();
		return blacklist;
	}

	/**
	 * Receipt of all elements of the table "blacklists" from the database
	 * 
	 * @return blacklist collection of objects of type "Blacklist"
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Blacklist> selectAllBlacklists() throws DaoException {
		List<Blacklist> blacklist = em.createNamedQuery("Blacklist.findAll").getResultList();
		return blacklist;
	}

	/**
	 * Delete the object of type "Blacklist" from the database
	 * 
	 * @param id
	 *            row ID in the database
	 * @throws DaoException
	 */
	@Override
	@Transactional
	public void deleteBlacklist(Integer id) throws DaoException {
		Blacklist blacklist = em.find(Blacklist.class, id);
		em.remove(blacklist);
	}

	/**
	 * Update the object of type "Blacklist" in the database
	 * 
	 * @param blacklist
	 *            object of type "Blacklist"
	 * @throws DaoException
	 */
	@Override
	@Transactional
	public void updateBlacklist(Blacklist blacklist) throws DaoException {
		em.merge(blacklist);

	}

}
