package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.global3Dmod.ÇDmodels.dao.ICommentDAO;
import com.global3Dmod.ÇDmodels.domain.Comment;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaCommentDAO")
public class CommentDAOImpl implements ICommentDAO {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Comment" to the database
	 * @param comment object of type "Comment"
	 * @throws DaoException
	 * */
	@Override
	public void insertComment(Comment comment) throws DaoException {
		em.persist(comment);

	}

	/**
	 * Receipt of all elements of the table "comments" from the database
	 * @return comments collection of objects of type "Comment"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> selectAllComments() throws DaoException {
		List<Comment> comments = em.createNamedQuery("Comment.findAll").getResultList();
		return comments;
	}

	/**
	 * Delete the object of type "Comment" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	public void deleteComment(Integer id) throws DaoException {
		Comment comment = em.find(Comment.class, id);
		em.remove(comment);
	}

	/**
	 * Update the object of type "Comment" in the database
	 * @param comment object of type "Comment"
	 * @throws DaoException
	 * */
	@Override
	public void updateComment(Comment comment) throws DaoException {
		em.merge(comment);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> selectCommentsByPost(Integer idPost) throws DaoException {
		List<Comment> comments = em.createNamedQuery("Comment.findByPost").setParameter("post_idPost", idPost).getResultList();
		for (Comment comment : comments) {
			Hibernate.initialize(comment.getUser());
		}
		return comments;
	}

}
