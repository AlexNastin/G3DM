package com.global3Dmod.�Dmodel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodel.dao.IRoleDAO;
import com.global3Dmod.�Dmodel.domain.Role;
import com.global3Dmod.�Dmodel.exception.DaoException;


@Repository("jpaRoleDAO")
public class RoleDAOImpl implements IRoleDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Role" to the database
	 * @param role object of type "Role"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertRole(Role role) throws DaoException {
		em.persist(role);

	}

	/**
	 * Receipt of all elements of the table "roles" from the database
	 * @return role collection of objects of type "Role"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> selectAllRoles() throws DaoException {
		List<Role> role = em.createNamedQuery("Role.findAll").getResultList();
		return role;
	}

	/**
	 * Delete the object of type "Role" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteRole(Integer id) throws DaoException {
		Role role = em.find(Role.class, id);
		em.remove(role);
	}

	/**
	 * Update the object of type "Role" in the database
	 * @param role object of type "Role"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateRole(Role role) throws DaoException {
		em.merge(role);
		
	}

}
