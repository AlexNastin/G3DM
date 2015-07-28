package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IComplainDAO;
import com.global3Dmod.ÇDmodels.domain.Complain;
import com.global3Dmod.ÇDmodels.exception.DaoException;

@Repository("jpaComplainDAO")
@Transactional
public class ComplainDAOImpl implements IComplainDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertComplain(Complain complain) throws DaoException {
		em.persist(complain);
	}

	@Override
	@Transactional
	public void updateComplain(Complain complain) throws DaoException {
		em.merge(complain);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Complain> selectAllComplains() throws DaoException {
		List<Complain> complains = em.createNamedQuery("Complain.findAll").getResultList();
		return complains;
	}

	@Override
	@Transactional
	public void deleteComplain(Integer idComplain) throws DaoException {
		Complain complain = em.find(Complain.class, idComplain);
		em.remove(complain);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Complain> selectComplainNotExists(Integer idUser, Integer idPost)
			throws DaoException {

		List<Complain> complains = em.createNamedQuery("Complain.findComplainByUser")
				.setParameter("user_idUser", idUser)
				.setParameter("post_idPost", idPost).getResultList();
		return complains;

	}

	@Override
	@Transactional
	public int selectCountComplainByPost(Integer idPost) throws DaoException {
		long resut = (long) em.createNamedQuery("Complain.colComplainByPost").setParameter("post_idPost", idPost).getSingleResult();
		int count = (int) resut;
		return count;
	}
	
	@Override
	@Transactional
	public int selectCountComplainByAllPosts(Integer idUser) throws DaoException {
		long resut = (long) em.createNamedQuery("Complain.colComplainByAllPosts").setParameter("user_idUser", idUser).getSingleResult();
		int count = (int) resut;
		return count;
	}

}
