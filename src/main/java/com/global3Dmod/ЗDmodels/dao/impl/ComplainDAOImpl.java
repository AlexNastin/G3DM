package com.global3Dmod.�Dmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.global3Dmod.�Dmodels.dao.IComplainDAO;
import com.global3Dmod.�Dmodels.domain.Complain;
import com.global3Dmod.�Dmodels.exception.DaoException;

@Repository("jpaComplainDAO")
public class ComplainDAOImpl implements IComplainDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertComplain(Complain complain) throws DaoException {
		em.persist(complain);
	}

	@Override
	public void updateComplain(Complain complain) throws DaoException {
		em.merge(complain);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Complain> selectAllComplains() throws DaoException {
		List<Complain> complains = em.createNamedQuery("Complain.findAll")
				.getResultList();
		return complains;
	}

	@Override
	public void deleteComplain(Integer idComplain) throws DaoException {
		Complain complain = em.find(Complain.class, idComplain);
		em.remove(complain);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Complain> selectComplainNotExists(Integer idUser, Integer idPost)
			throws DaoException {

		List<Complain> complains = em
				.createNamedQuery("Complain.findComplainByUser")
				.setParameter("user_idUser", idUser)
				.setParameter("post_idPost", idPost).getResultList();
		return complains;

	}

	@Override
	public int selectCountComplainByPost(Integer idPost) throws DaoException {
		long resut = (long) em.createNamedQuery("Complain.colComplainByPost")
				.setParameter("post_idPost", idPost).getSingleResult();
		int count = (int) resut;
		return count;
	}

	@Override
	public int selectCountComplainByAllPosts(Integer idUser)
			throws DaoException {
		long resut = (long) em
				.createNamedQuery("Complain.colComplainByAllPosts")
				.setParameter("user_idUser", idUser).getSingleResult();
		int count = (int) resut;
		return count;
	}

	@Override
	public void deleteComplains(Integer idPost) throws DaoException {
		em.createNamedQuery("Complain.deleteComplainByIdPost")
				.setParameter("post_idPost", idPost).executeUpdate();
	}

}
