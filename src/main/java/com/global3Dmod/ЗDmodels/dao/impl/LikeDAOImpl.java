package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ILikeDAO;
import com.global3Dmod.ÇDmodels.domain.Like;
import com.global3Dmod.ÇDmodels.exception.DaoException;

@Repository("jpaLikeDAO")
@Transactional
public class LikeDAOImpl implements ILikeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertLike(Like like) throws DaoException {
		em.persist(like);
	}

	@Override
	@Transactional
	public void updateLike(Like like) throws DaoException {
		em.merge(like);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Like> selectAllLikes() throws DaoException {
		List<Like> likes = em.createNamedQuery("Like.findAll").getResultList();
		return likes;
	}

	@Override
	@Transactional
	public void deleteLike(Integer idLike) throws DaoException {
		Like like = em.find(Like.class, idLike);
		em.remove(like);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Like> selectLikeNotExists(Integer idUser, Integer idPost)
			throws DaoException {

		List<Like> likes = em.createNamedQuery("Like.findLikeByUser")
				.setParameter("user_idUser", idUser)
				.setParameter("post_idPost", idPost).getResultList();
		return likes;

	}

	@Override
	@Transactional
	public int selectCountLikeByPost(Integer idPost) throws DaoException {
		long resut = (long) em.createNamedQuery("Like.colLikeByPost").setParameter("post_idPost", idPost).getSingleResult();
		int count = (int) resut;
		return count;
	}
	
	@Override
	@Transactional
	public int selectCountLikeByAllPosts(Integer idUser) throws DaoException {
		long resut = (long) em.createNamedQuery("Like.colLikeByAllPosts").setParameter("user_idUser", idUser).getSingleResult();
		int count = (int) resut;
		return count;
	}

}
