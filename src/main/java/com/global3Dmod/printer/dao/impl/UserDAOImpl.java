package com.global3Dmod.printer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.printer.dao.UserDAO;
import com.global3Dmod.printer.domain.User;

@Repository("jpaServiceUser")
@Transactional
public class UserDAOImpl  implements UserDAO{

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
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
	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
