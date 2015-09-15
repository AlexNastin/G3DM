package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.PasswordResetToken;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface IPasswordResetTokenDAO {

	public void updatePasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public void insertPasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public List<PasswordResetToken> selectAllPasswordResetTokens()
			throws DaoException;

	public void deletePasswordResetToken(Integer idToken) throws DaoException;
	
	public PasswordResetToken selectTokenByUser(Integer idUser) throws DaoException;

	public PasswordResetToken selectTokenByToken(String token) throws DaoException;

}
