package com.global3Dmod.�Dmodels.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.PropertyName;
import com.global3Dmod.�Dmodels.dao.IPostDAO;
import com.global3Dmod.�Dmodels.domain.Post;
import com.global3Dmod.�Dmodels.exception.DaoException;
import com.global3Dmod.�Dmodels.property.PropertyManagerG3DM;
import com.global3Dmod.�Dmodels.property.PropertyNameG3DM;

@Repository("jpaPostDAO")
@Transactional
public class PostDAOImpl implements IPostDAO {

	int limitPostsOnPage = 5;

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PropertyManagerG3DM propertyManagerG3DM;
	
	
	

	/**
	 * Insert the object of type "Post" to the database
	 * 
	 * @param post
	 *            object of type "Post"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertPost(Post post) throws DaoException {
		em.persist(post);

	}

	/**
	 * Receipt of all elements of the table "posts" from the database
	 * 
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
	 * 
	 * @param id
	 *            row ID in the database
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
	 * 
	 * @param post
	 *            object of type "Post"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updatePost(Post post) throws DaoException {
		em.merge(post);

	}
	//update
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByDesigner(Integer idDesigner)
			throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByDesigner")
				.setParameter("idUser", idDesigner).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getTechnologies());
		}
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByDesignerForSort(Integer idDesigner)
			throws DaoException {
		 String serverPath = propertyManagerG3DM.getValue(PropertyNameG3DM.PATH_FILE);
		 System.out.println(serverPath);
		List<Post> posts = em.createNamedQuery("Post.findByDesigner")
				.setParameter("idUser", idDesigner).getResultList();
		return posts;
	}
	//update
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByUserForSort(Integer idUser)
			throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByUser")
				.setParameter("user_idUser", idUser).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getUser());
			Hibernate.initialize(post.getPostPhotos());
		}
		return posts;
	}
	//update
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10(Integer page) throws DaoException {
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findAll")
				.setFirstResult(startPost).setMaxResults(limitPostsOnPage)
				.getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getTechnologies());
		}
		return posts;
	}
	//update
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10ByCategory(Integer page,
			Integer idCategory) throws DaoException {
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findByCategory")
				.setParameter("category_idCategory", idCategory)
				.setFirstResult(startPost).setMaxResults(limitPostsOnPage)
				.getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getTechnologies());
			Hibernate.initialize(post.getUser());
			Hibernate.initialize(post.getComments());
		}
		return posts;
	}
	//update
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsLimit10BySubcategory(Integer page,
			Integer idCategory, Integer idSubcategory) throws DaoException {
		int startPost = page * limitPostsOnPage - limitPostsOnPage;
		List<Post> posts = em.createNamedQuery("Post.findBySubcategory")
				.setParameter("category_idCategory", idCategory)
				.setParameter("subcategory_idSubcategory", idSubcategory)
				.setFirstResult(startPost).setMaxResults(limitPostsOnPage)
				.getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
			Hibernate.initialize(post.getTechnologies());
			Hibernate.initialize(post.getUser());
			Hibernate.initialize(post.getComments());
		}
		return posts;
	}
	//update
	@Override
	@Transactional
	public Post selectPost(Integer idPost) throws DaoException {
		Post post = (Post) em.createNamedQuery("Post.findOneById")
				.setParameter("idPost", idPost).getSingleResult();
		Hibernate.initialize(post.getPostPhotos());
		Hibernate.initialize(post.getTechnologies());
		Hibernate.initialize(post.getUser());
		Hibernate.initialize(post.getCategory());
		Hibernate.initialize(post.getSubcategory());
		Hibernate.initialize(post.getDisProgram());
		return post;
	}

	@Override
	@Transactional
	public Post selectPostWithoutAll(Integer idPost) throws DaoException {
		Post post = (Post) em.createNamedQuery("Post.findOneById")
				.setParameter("idPost", idPost).getSingleResult();
		return post;
	}

	@Override
	public int countPostByDesigner(Integer idUser) throws DaoException {
		long resut = (long) em.createNamedQuery("Post.colPostByUser")
				.setParameter("user_idUser", idUser).getSingleResult();
		int count = (int) resut;
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByModeratingForSort() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByModerating").getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getUser());
		}
		return posts;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByRejectingForSort() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByRejecting").getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getUser());
		}
		return posts;
	}
	//update
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectTop4ByLike() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findTop4ByLike").setMaxResults(4).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getPostPhotos());
		}
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectComplainedPostsForSort() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findComplainedPosts").getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getUser());
		}
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Map<Integer, Integer> selectColPostsForAllUsers()
			throws DaoException {
		Map<Integer, Integer> colPostsWithIdDesigners = new HashMap<Integer, Integer>();
		List<Integer> idDesigners = em.createNamedQuery("Post.allDesignersHavePosts").getResultList();
		List<Long> colPosts = em.createNamedQuery("Post.colPostAllUsers").getResultList();
		for (int i = 0; i < idDesigners.size(); i++) {
			colPostsWithIdDesigners.put(idDesigners.get(i), colPosts.get(i).intValue());
		}
		return colPostsWithIdDesigners;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Integer> selectIdDesignersHavePosts() throws DaoException {
		List<Integer> idDesigners = em.createNamedQuery("Post.allDesignersHavePosts").getResultList();
		return idDesigners;
	}

}
