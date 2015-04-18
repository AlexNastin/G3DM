package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IRoleDAO;
import com.global3Dmod.ÇDmodels.domain.Role;


@Repository("jpaRoleDAO")
@Transactional
public class RoleDAOImpl implements IRoleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertRole(Role role) {
		em.persist(role);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Role> selectAllRoles() {
		List<Role> role = em.createNamedQuery("Role.findAll").getResultList();
		return role;
	}

	@Override
	@Transactional
	public void deleteRole(Integer id) {
		Role role = em.find(Role.class, id);
		em.remove(role);
	}

	@Override
	@Transactional
	public void updateRole(Role role) {
		em.merge(role);
		
	}

}
