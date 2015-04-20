package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ICommentDAO;
import com.global3Dmod.ÇDmodels.domain.Comment;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaCommentDAO")
@Transactional
public class CommentDAOImpl implements ICommentDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertComment(Comment comment) throws DaoException {
		em.persist(comment);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Comment> selectAllComments() throws DaoException {
		List<Comment> comments = em.createNamedQuery("Comment.findAll").getResultList();
		return comments;
	}

	@Override
	@Transactional
	public void deleteComment(Integer id) throws DaoException {
		Comment comment = em.find(Comment.class, id);
		em.remove(comment);
	}

	@Override
	@Transactional
	public void updateComment(Comment comment) throws DaoException {
		em.merge(comment);
		
	}

}
