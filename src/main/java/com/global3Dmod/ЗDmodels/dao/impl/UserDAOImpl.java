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

	/**
	 * Insert the object of type "User" to the database
	 * @param user object of type "User"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertUser(User user) throws DaoException {
		em.persist(user);

	}

	/**
	 * Receipt of all elements of the table "users" from the database
	 * @return users collection of objects of type "User"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> selectAllUsers() throws DaoException {
		List<User> users = em.createNamedQuery("User.findAll").getResultList();
		return users;
	}

	/**
	 * Delete the object of type "User" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteUser(Integer id) throws DaoException {
		User user = em.find(User.class, id);
		em.remove(user);
	}

	/**
	 * Update the object of type "User" in the database
	 * @param user object of type "User"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateUser(User user) throws DaoException {
		em.merge(user);

	}

	/**
	 * Receipt of 3 elements of the table "users" from the database
	 * @return usersTop collection of objects of type "User"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> selectTop3Users() throws DaoException{
		List<User> usersTop = em.createNamedQuery("User.findTop3")
				.setFirstResult(0).setMaxResults(3).getResultList();
		return usersTop;
	}
	
	/**
	 * Receipt of all user`s email address of the table "users" from the database
	 * @return emails collection of objects of type "String"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectAllEmail() throws DaoException {
		List<String> emails = em.createNamedQuery("User.findAllEmail").getResultList();
		return emails;
	}
	
	/**
	 * Receipt of all user`s nickname of the table "users" from the database
	 * @return nickNames collection of objects of type "String"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectAllNickName() throws DaoException {
		List<String> nickNames = em.createNamedQuery("User.findAllNickName").getResultList();
		return nickNames;
	}

}
