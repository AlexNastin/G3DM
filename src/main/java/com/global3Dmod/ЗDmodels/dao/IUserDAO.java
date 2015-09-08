package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IUserDAO {
	
	public void updateUser(User user) throws DaoException;
	
	public User selectUser(String login) throws DaoException;
	
	public User selectUserWithCountry(String login) throws DaoException;
	
	public User selectUserById(Integer id) throws DaoException;

	public void insertUser(User user) throws DaoException;

	public List<User> selectAllUsers() throws DaoException;

	public void deleteUser(Integer id) throws DaoException;

	public List<String> selectAllEmail() throws DaoException;
	
	public List<String> selectAllNickName() throws DaoException;
	
	public User selectUserByIdWithoutAll(Integer id) throws DaoException;
	
	public List<User> selectModeratorsForSort() throws DaoException;
	
	public List<User> selectDesignersForSort() throws DaoException;
	
	public List<User> selectUsersForSort() throws DaoException;

	public List<User> selectTop4ByRating() throws DaoException;

	public int selectNumberOfAllUsers() throws DaoException;

	public int selectNumberOfDesigners() throws DaoException;;

	public int selectNumberOfModerators() throws DaoException;;

	public int selectNumberOfUsers() throws DaoException;

	public int selectNumberOfAdmins() throws DaoException;
}
