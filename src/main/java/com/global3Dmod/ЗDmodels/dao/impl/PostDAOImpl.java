package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
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

	/**
	 * Insert the object of type "Post" to the database
	 * @param post object of type "Post"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
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
	public void updatePost(Post post) throws DaoException {
		em.merge(post);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByDesigner(Integer id) throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByDesigner").setParameter("idUser", id).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getPrinters());
		}
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10(Integer page) throws DaoException {
		int limitPostsOnPage = 5;
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findAll").setFirstResult(startPost).setMaxResults(limitPostsOnPage).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getPrinters());
			System.out.println(post.getIdPost());
		}
		return posts;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10ByDesigner(Integer page, Integer idDesigner) throws DaoException {
		int limitPostsOnPage = 10;
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findByDesigner").setParameter("idUser", idDesigner).setFirstResult(startPost).setMaxResults(limitPostsOnPage).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getPrinters());
			System.out.println(post.getIdPost());
		}
		return posts;
	}

}
