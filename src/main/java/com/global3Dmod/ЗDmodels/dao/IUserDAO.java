package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IUserDAO {
	
	public void update(User user) throws DaoException;

	public void add(User user) throws DaoException;

	public List<User> getAllUsers() throws DaoException;
	
	public List<User> getTop3Users() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
