package com.global3Dmod.�Dmodel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodel.dao.IAvatarDAO;
import com.global3Dmod.�Dmodel.domain.Avatar;
import com.global3Dmod.�Dmodel.exception.DaoException;

@Repository("jpaAvatarDAO")
public class AvatarDAOImpl implements IAvatarDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Avatar" to the database
	 * 
	 * @param avatar
	 *            object of type "Avatar"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertAvatar(Avatar avatar) throws DaoException {
		em.persist(avatar);

	}

	/**
	 * Receipt of all elements of the table "avatars" from the database
	 * 
	 * @return avatar collection of objects of type "Avatar"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Avatar> selectAllAvatars() throws DaoException {
		List<Avatar> avatar = em.createNamedQuery("Avatar.findAll")
				.getResultList();
		return avatar;
	}

	/**
	 * Delete the object of type "Avatar" from the database
	 * 
	 * @param id
	 *            row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteAvatar(Integer id) throws DaoException {
		Avatar avatar = em.find(Avatar.class, id);
		em.remove(avatar);
	}

	/**
	 * Update the object of type "Avatar" in the database
	 * 
	 * @param avatar
	 *            object of type "Avatar"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateAvatar(Avatar avatar) throws DaoException {
		em.merge(avatar);

	}

}
