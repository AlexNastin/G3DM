package com.global3Dmod.printer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.printer.dao.IRoleDAO;
import com.global3Dmod.printer.domain.Role;

@Component
@Repository("jpaRoleDAO")
@Transactional
public class RoleDAOImpl implements IRoleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Role role) {
		em.persist(role);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Role> getAllRoles() {
		List<Role> role = em.createNamedQuery("Role.findAll").getResultList();
		return role;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Role role = em.find(Role.class, id);
		em.remove(role);
	}

	@Override
	@Transactional
	public void update(Role role) {
		em.merge(role);
		
	}

}
