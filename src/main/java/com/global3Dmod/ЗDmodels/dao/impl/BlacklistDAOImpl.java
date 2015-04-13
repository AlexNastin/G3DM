package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IBlacklistDAO;
import com.global3Dmod.ÇDmodels.domain.Blacklist;


@Repository("jpaBlacklistDAO")
@Transactional
public class BlacklistDAOImpl implements IBlacklistDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Blacklist blacklist) {
		em.persist(blacklist);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Blacklist> getAllBlacklists() {
		List<Blacklist> blacklist = em.createNamedQuery("Blacklist.findAll").getResultList();
		return blacklist;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Blacklist blacklist = em.find(Blacklist.class, id);
		em.remove(blacklist);
	}

	@Override
	@Transactional
	public void update(Blacklist blacklist) {
		em.merge(blacklist);
		
	}

}
