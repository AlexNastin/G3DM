package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IPasswordResetTokenDAO;
import com.global3Dmod.ÇDmodels.domain.PasswordResetToken;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.DaoException;

@Repository("jpaPasswordResetTokenDAO")
@Transactional
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
	@Transactional
	public List<PasswordResetToken> selectAllPasswordResetTokens()
			throws DaoException {
		List<PasswordResetToken> passwordResetTokens = em.createNamedQuery(
				"PasswordResetToken.findAll").getResultList();
		return passwordResetTokens;
	}

	@Override
	@Transactional
	public void deletePasswordResetToken(Integer idToken) throws DaoException {
		PasswordResetToken passwordResetToken = em.find(
				PasswordResetToken.class, idToken);
		em.remove(passwordResetToken);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
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
}
