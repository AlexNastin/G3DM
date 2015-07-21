package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.PasswordResetToken;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IPasswordResetTokenDAO {

	public void updatePasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public void insertPasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public List<PasswordResetToken> selectAllPasswordResetTokens()
			throws DaoException;

	public void deletePasswordResetToken(Integer idToken) throws DaoException;

}
