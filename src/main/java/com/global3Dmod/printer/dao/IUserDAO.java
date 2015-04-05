package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.User;

public interface IUserDAO {

	public void addUser(User user);

	public List<User> getAllUsers();

	public void removeUser(Integer id);

}
