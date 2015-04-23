package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IUserDAO;
import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.DaoException;

@Repository("jpaUserDAO")
@Transactional
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertUser(User user) throws DaoException {
		em.persist(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> selectAllUsers() throws DaoException {
		List<User> users = em.createNamedQuery("User.findAll").getResultList();
		return users;
	}

	@Override
	@Transactional
	public void deleteUser(Integer id) throws DaoException {
		User user = em.find(User.class, id);
		em.remove(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) throws DaoException {
		em.merge(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> selectTop3Users() {
		List<User> usersTop = em.createNamedQuery("User.findTop3")
				.setFirstResult(0).setMaxResults(3).getResultList();
		return usersTop;
	}

	@Override
	public List<String> selectAllEmail() throws DaoException {
		@SuppressWarnings("unchecked")
		List<String> emails = em.createNamedQuery("User.getAllEmail").getResultList();
		return emails;
	}

}
