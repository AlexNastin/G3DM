package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.ICommentDAO;
import com.global3Dmod.ÇDmodels.dao.IRejectMessageDAO;
import com.global3Dmod.ÇDmodels.domain.Comment;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.domain.RejectMessage;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaRejectMessageDAO")
@Transactional
public class RejectMessageDAOImpl implements IRejectMessageDAO {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "RejectMessage" to the database
	 * @param comment object of type "RejectMessage"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertRejectMessage(RejectMessage rejectMessage) throws DaoException {
		em.persist(rejectMessage);

	}

	/**
	 * Receipt of all elements of the table "reject_message" from the database
	 * @return comments collection of objects of type "RejectMessage"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<RejectMessage> selectAllRejectMessages() throws DaoException {
		List<RejectMessage> rejectMessages = em.createNamedQuery("RejectMessage.findAll").getResultList();
		return rejectMessages;
	}

	/**
	 * Delete the object of type "RejectMessage" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteRejectMessage(Integer id) throws DaoException {
		RejectMessage rejectMessage = em.find(RejectMessage.class, id);
		em.remove(rejectMessage);
	}

	/**
	 * Update the object of type "RejectMessage" in the database
	 * @param reject message object of type "RejectMessage"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateRejectMessage(RejectMessage rejectMessage) throws DaoException {
		em.merge(rejectMessage);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public RejectMessage selectRejectMessageByPost(Integer idPost) throws DaoException {
		RejectMessage rejectMessage = null;
		List<RejectMessage> rejectMessages = em.createNamedQuery("RejectMessage.findByPost").setParameter("post_idPost", idPost).getResultList();
		if(!rejectMessages.isEmpty()) {
			rejectMessage = rejectMessages.get(0);
		}
//		Hibernate.initialize(rejectMessage.getUser());
		return rejectMessage;
	}

}
