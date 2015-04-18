package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IPostDAO;
import com.global3Dmod.ÇDmodels.domain.Post;


@Repository("jpaPostDAO")
@Transactional
public class PostDAOImpl implements IPostDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertPost(Post post) {
		em.persist(post);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Post> selectAllPosts() {
		List<Post> post = em.createNamedQuery("Post.findAll").getResultList();
		return post;
	}

	@Override
	@Transactional
	public void deletePost(Integer id) {
		Post post = em.find(Post.class, id);
		em.remove(post);
	}

	@Override
	@Transactional
	public void updatePost(Post post) {
		em.merge(post);
		
	}

}
