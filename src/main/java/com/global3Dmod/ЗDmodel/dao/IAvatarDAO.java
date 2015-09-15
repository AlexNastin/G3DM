package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.Avatar;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface IAvatarDAO {
	
	public void updateAvatar(Avatar avatar) throws DaoException; 

	public void insertAvatar(Avatar avatar) throws DaoException; 

	public List<Avatar> selectAllAvatars() throws DaoException; 

	public void deleteAvatar(Integer id) throws DaoException; 

}
