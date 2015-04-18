package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Avatar;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IAvatarDAO {
	
	public void updateAvatar(Avatar avatar) throws DaoException; //modifyAvatar

	public void insertAvatar(Avatar avatar) throws DaoException; //addAvatar

	public List<Avatar> selectAllAvatars() throws DaoException; //getAllAvatars

	public void deleteAvatar(Integer id) throws DaoException; //removeAvatar

}
