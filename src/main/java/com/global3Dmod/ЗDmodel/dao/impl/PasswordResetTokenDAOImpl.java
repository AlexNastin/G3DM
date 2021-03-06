package com.global3Dmod.�Dmodel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodel.dao.IPasswordResetTokenDAO;
import com.global3Dmod.�Dmodel.domain.PasswordResetToken;
import com.global3Dmod.�Dmodel.exception.DaoException;

@Repository("jpaPasswordResetTokenDAO")
public class PasswordResetTokenDAOImpl implements IPasswordResetTokenDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void updatePasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException {
		em.merge(passwordResetToken);

	}

	@Override
	@Transactional
	public void insertPasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException {
		em.persist(passwordResetToken);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PasswordResetToken> selectAllPasswordResetTokens()
			throws DaoException {
		List<PasswordResetToken> passwordResetTokens = em.createNamedQuery(
				"PasswordResetToken.findAll").getResultList();
		return passwordResetTokens;
	}

	@Override
	@Transactional
	public void deletePasswordResetToken(Integer idToken) throws DaoException {
		PasswordResetToken passwordResetToken = em.find(PasswordResetToken.class, idToken);
		em.remove(passwordResetToken);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PasswordResetToken selectTokenByUser(Integer idUser)
			throws DaoException {
		PasswordResetToken passwordResetToken = null;
		List<PasswordResetToken> passwordResetTokens = em
				.createNamedQuery("PasswordResetToken.findTokenByUser")
				.setParameter("user_idUser", idUser).getResultList();
		if (!passwordResetTokens.isEmpty()) {
			passwordResetToken = passwordResetTokens.get(0);
		}
		return passwordResetToken;

	}
	@SuppressWarnings("unchecked")
	@Override
	public PasswordResetToken selectTokenByToken(String token) throws DaoException {
		PasswordResetToken passwordResetToken = null;
		List<PasswordResetToken> passwordResetTokens = em
				.createNamedQuery("PasswordResetToken.findTokenByToken")
				.setParameter("token", token).getResultList();
		if (!passwordResetTokens.isEmpty()) {
			passwordResetToken = passwordResetTokens.get(0);
		}
		return passwordResetToken;

	}
}
