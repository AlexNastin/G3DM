package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.global3Dmod.ÇDmodels.dao.IPasswordResetTokenDAO;
import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.domain.PasswordResetToken;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public class PasswordResetTokenDAOImpl implements IPasswordResetTokenDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void updatePasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException {
		em.merge(passwordResetToken);

	}

	@Override
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
	public void deletePasswordResetToken(Integer idToken) throws DaoException {
		PasswordResetToken passwordResetToken = em.find(
				PasswordResetToken.class, idToken);
		em.remove(passwordResetToken);

	}

}
