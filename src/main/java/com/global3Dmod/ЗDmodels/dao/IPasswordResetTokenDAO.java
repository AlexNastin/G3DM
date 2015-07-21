package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.PasswordResetToken;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IPasswordResetTokenDAO {

	public void updatePasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public void insertPasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public List<PasswordResetToken> selectAllPasswordResetTokens()
			throws DaoException;

	public void deletePasswordResetToken(Integer idToken) throws DaoException;

}
