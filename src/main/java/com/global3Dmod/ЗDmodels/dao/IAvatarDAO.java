package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Avatar;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IAvatarDAO {
	
	public void updateAvatar(Avatar avatar) throws DaoException; 

	public void insertAvatar(Avatar avatar) throws DaoException; 

	public List<Avatar> selectAllAvatars() throws DaoException; 

	public void deleteAvatar(Integer id) throws DaoException; 

}
