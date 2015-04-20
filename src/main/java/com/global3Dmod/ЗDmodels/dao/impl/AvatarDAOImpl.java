package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IAvatarDAO;
import com.global3Dmod.ÇDmodels.domain.Avatar;
import com.global3Dmod.ÇDmodels.exception.DaoException;

@Repository("jpaAvatarDAO")
@Transactional
public class AvatarDAOImpl implements IAvatarDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertAvatar(Avatar avatar) throws DaoException {
		em.persist(avatar);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Avatar> selectAllAvatars() throws DaoException {
		List<Avatar> avatar = em.createNamedQuery("Avatar.findAll").getResultList();
		return avatar;
	}

	@Override
	@Transactional
	public void deleteAvatar(Integer id) throws DaoException {
		Avatar avatar = em.find(Avatar.class, id);
		em.remove(avatar);
	}

	@Override
	@Transactional
	public void updateAvatar(Avatar avatar) throws DaoException {
		em.merge(avatar);
		
	}

}
