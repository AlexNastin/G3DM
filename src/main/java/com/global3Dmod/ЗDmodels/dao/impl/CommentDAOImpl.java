package com.global3Dmod.�Dmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodels.dao.ICommentDAO;
import com.global3Dmod.�Dmodels.domain.Comment;


@Repository("jpaCommentDAO")
@Transactional
public class CommentDAOImpl implements ICommentDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertComment(Comment comment) {
		em.persist(comment);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Comment> selectAllComments() {
		List<Comment> comments = em.createNamedQuery("Comment.findAll").getResultList();
		return comments;
	}

	@Override
	@Transactional
	public void deleteComment(Integer id) {
		Comment comment = em.find(Comment.class, id);
		em.remove(comment);
	}

	@Override
	@Transactional
	public void updateComment(Comment comment) {
		em.merge(comment);
		
	}

}
