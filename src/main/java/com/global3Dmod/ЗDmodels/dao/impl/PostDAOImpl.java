package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IPostDAO;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaPostDAO")
@Transactional
public class PostDAOImpl implements IPostDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertPost(Post post) throws DaoException {
		em.persist(post);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectAllPosts() throws DaoException {
		List<Post> post = em.createNamedQuery("Post.findAll").getResultList();
		return post;
	}

	@Override
	@Transactional
	public void deletePost(Integer id) throws DaoException {
		Post post = em.find(Post.class, id);
		em.remove(post);
	}

	@Override
	@Transactional
	public void updatePost(Post post) throws DaoException {
		em.merge(post);
		
	}

}
