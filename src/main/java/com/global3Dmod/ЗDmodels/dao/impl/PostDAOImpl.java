package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM;
import com.global3Dmod.ÇDmodels.dao.IPostDAO;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaPostDAO")
@Transactional
public class PostDAOImpl implements IPostDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Post" to the database
	 * @param post object of type "Post"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void insertPost(Post post) throws DaoException {
		em.persist(post);

	}

	/**
	 * Receipt of all elements of the table "posts" from the database
	 * @return post collection of objects of type "Post"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@AspectDaoG3DM
	public List<Post> selectAllPosts() throws DaoException {
		List<Post> post = em.createNamedQuery("Post.findAll").getResultList();
		return post;
	}

	/**
	 * Delete the object of type "Post" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void deletePost(Integer id) throws DaoException {
		Post post = em.find(Post.class, id);
		em.remove(post);
	}

	/**
	 * Update the object of type "Post" in the database
	 * @param post object of type "Post"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
	public void updatePost(Post post) throws DaoException {
		em.merge(post);
		
	}

}
