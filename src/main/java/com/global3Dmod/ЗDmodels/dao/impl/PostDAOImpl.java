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
	
	int limitPostsOnPage = 5;

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
	public void deletePost(Integer idPost) throws DaoException {
		Post post = em.find(Post.class, idPost);
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
	public List<Post> selectPostsByDesigner(Integer idDesigner) throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByDesigner").setParameter("idUser", idDesigner).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getPrinters());
		}
		return posts;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByDesignerForSort(Integer idDesigner) throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByDesigner").setParameter("idUser", idDesigner).getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10(Integer page) throws DaoException {
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findAll").setFirstResult(startPost).setMaxResults(limitPostsOnPage).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getPrinters());
		}
		return posts;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10ByCategory(Integer page, Integer idCategory) throws DaoException {
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findByCategory").setParameter("category_idCategory", idCategory).setFirstResult(startPost).setMaxResults(limitPostsOnPage).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getPrinters());
		}
		return posts;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10BySubcategory(Integer page, Integer idCategory, Integer idSubcategory) throws DaoException {
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findBySubcategory").setParameter("category_idCategory", idCategory).setParameter("subcategory_idSubcategory", idSubcategory).setFirstResult(startPost).setMaxResults(limitPostsOnPage).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getPrinters());
		}
		return posts;
	}

	@Override
	@Transactional
	public Post selectPost(Integer idPost) throws DaoException {
		Post post = (Post) em.createNamedQuery("Post.findOneById").setParameter("idPost", idPost).getSingleResult();
		Hibernate.initialize(post.getPostPhotos());
		Hibernate.initialize(post.getPrinters());
		Hibernate.initialize(post.getUser());
		Hibernate.initialize(post.getCategory());
		Hibernate.initialize(post.getDisProgram());
		return post;
	}

}
