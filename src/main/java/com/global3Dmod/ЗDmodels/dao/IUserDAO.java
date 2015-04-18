package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IUserDAO {
	
	public void updateUser(User user) throws DaoException;

	public void insertUser(User user) throws DaoException;

	public List<User> selectAllUsers() throws DaoException;
	
	public List<User> selectTop3Users() throws DaoException;

	public void deleteUser(Integer id) throws DaoException;

}
