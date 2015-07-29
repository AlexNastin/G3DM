package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IUserDAO {
	
	public void updateUser(User user) throws DaoException;
	
	public User selectUser(String login) throws DaoException;
	
	public User selectUserById(Integer id) throws DaoException;

	public void insertUser(User user) throws DaoException;

	public List<User> selectAllUsers() throws DaoException;
	
	public List<User> selectTop3Users() throws DaoException;

	public void deleteUser(Integer id) throws DaoException;

	public List<String> selectAllEmail() throws DaoException;
	
	public List<String> selectAllNickName() throws DaoException;
	
	public User selectUserByIdWithoutAll(Integer id) throws DaoException;
	
	public List<User> selectModeratorsForSort() throws DaoException;
	
	public List<User> selectDesignersForSort() throws DaoException;
	
	public List<User> selectUsersForSort() throws DaoException;
}
