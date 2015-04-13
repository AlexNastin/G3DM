package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IUserDAO;
import com.global3Dmod.ÇDmodels.domain.User;


@Repository("jpaUserDAO")
@Transactional
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(User user) {
		em.persist(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getAllUsers() {
		List<User> users = em.createNamedQuery("User.findAll").getResultList();
		return users;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		User user = em.find(User.class, id);
		em.remove(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		em.merge(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getTop3Users() {
		List<User> usersTop = em.createNamedQuery("User.findTop3").setFirstResult(0).setMaxResults(3).getResultList();
		return usersTop;
	}

}
