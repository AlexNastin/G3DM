package com.global3Dmod.printer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.printer.dao.ICommentDAO;
import com.global3Dmod.printer.domain.Comment;

@Component
@Repository("jpaCommentDAO")
@Transactional
public class CommentDAOImpl implements ICommentDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Comment comment) {
		em.persist(comment);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Comment> getAllComments() {
		List<Comment> comments = em.createNamedQuery("Comment.findAll").getResultList();
		return comments;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Comment comment = em.find(Comment.class, id);
		em.remove(comment);
	}

	@Override
	@Transactional
	public void update(Comment comment) {
		em.merge(comment);
		
	}

}
