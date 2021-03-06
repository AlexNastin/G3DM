package com.global3Dmod.�Dmodel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodel.dao.IPostDAO;
import com.global3Dmod.�Dmodel.domain.Post;
import com.global3Dmod.�Dmodel.exception.DaoException;

@Repository("jpaPostDAO")
public class PostDAOImpl implements IPostDAO {

	@PersistenceContext
	private EntityManager em;

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPostsByDesigner(Integer idDesigner)
			throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByDesigner")
				.setParameter("idUser", idDesigner).getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getTechnologies());
		}
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> selectPostsByDesignerForSort(Integer idDesigner)
			throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByDesigner")
				.setParameter("idUser", idDesigner).getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> selectPostsByUserForSort(Integer idUser)
			throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByUser")
				.setParameter("user_idUser", idUser).getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectPosts() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findAll").getResultList();
		for (Post post : posts) {
			Hibernate.initialize(post.getTechnologies());
		}
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> selectPostsByCategory(Integer idCategory) throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByCategory")
				.setParameter("category_idCategory", idCategory).getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> selectPostsByCategoryBySubcategory(Integer idCategory, Integer idSubcategory) throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findBySubcategory")
				.setParameter("category_idCategory", idCategory)
				.setParameter("subcategory_idSubcategory", idSubcategory).getResultList();
		return posts;
	}

	@Override
	@Transactional
	public Post selectPost(Integer idPost) throws DaoException {
		Post post = (Post) em.createNamedQuery("Post.findOneById")
				.setParameter("idPost", idPost).getSingleResult();
		Hibernate.initialize(post.getTechnologies());
		return post;
	}

	@Override
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
	public List<Post> selectPostsByModeratingForSort() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByModerating")
				.getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> selectPostsByRejectingForSort() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findByRejecting")
				.getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> selectTop4ByLike() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findTop4ByLike")
				.setMaxResults(4).getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> selectComplainedPostsForSort() throws DaoException {
		List<Post> posts = em.createNamedQuery("Post.findComplainedPosts")
				.getResultList();
		return posts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, Integer> selectColPostsForAllUsers()
			throws DaoException {
		Map<Integer, Integer> colPostsWithIdDesigners = new HashMap<Integer, Integer>();
		List<Integer> idDesigners = em.createNamedQuery(
				"Post.allDesignersHavePosts").getResultList();
		List<Long> colPosts = em.createNamedQuery("Post.colPostAllUsers")
				.getResultList();
		for (int i = 0; i < idDesigners.size(); i++) {
			colPostsWithIdDesigners.put(idDesigners.get(i), colPosts.get(i)
					.intValue());
		}
		return colPostsWithIdDesigners;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> selectIdDesignersHavePosts() throws DaoException {
		List<Integer> idDesigners = em.createNamedQuery(
				"Post.allDesignersHavePosts").getResultList();
		return idDesigners;
	}

	@Override
	public int selectNumberOfAllPosts() throws DaoException {
		long resut = (long) em.createNamedQuery("Post.numberOfAllPosts").getSingleResult();
		int allPosts = (int) resut;
		return allPosts;
	}

	@Override
	public int selectNumberOfDeletedPosts() throws DaoException {
		long resut = (long) em.createNamedQuery("Post.numberOfDeletedPosts").getSingleResult();
		int deletedPosts = (int) resut;
		return deletedPosts;
	}

	@Override
	public int selectNumberOfRejectedPosts() throws DaoException {
		long resut = (long) em.createNamedQuery("Post.numberOfRejectedPosts").getSingleResult();
		int rejectedPosts = (int) resut;
		return rejectedPosts;
	}

	@Override
	public int selectNumberOfModeratingPosts() throws DaoException {
		long resut = (long) em.createNamedQuery("Post.numberOfModeratingPosts").getSingleResult();
		int moderatingPosts = (int) resut;
		return moderatingPosts;
	}

	@Override
	public int selectNumberOfPublishingPosts() throws DaoException {
		long resut = (long) em.createNamedQuery("Post.numberOfPublishingPosts").getSingleResult();
		int publishingPosts = (int) resut;
		return publishingPosts;
	}

}
