package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IAvatarDAO;
import com.global3Dmod.ÇDmodels.domain.Avatar;

@Repository("jpaAvatarDAO")
@Transactional
public class AvatarDAOImpl implements IAvatarDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertAvatar(Avatar avatar) {
		em.persist(avatar);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Avatar> selectAllAvatars() {
		List<Avatar> avatar = em.createNamedQuery("Avatar.findAll").getResultList();
		return avatar;
	}

	@Override
	@Transactional
	public void deleteAvatar(Integer id) {
		Avatar avatar = em.find(Avatar.class, id);
		em.remove(avatar);
	}

	@Override
	@Transactional
	public void updateAvatar(Avatar avatar) {
		em.merge(avatar);
		
	}

}
