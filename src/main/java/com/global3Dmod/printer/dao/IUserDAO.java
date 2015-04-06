package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.User;

public interface IUserDAO {
	
	public void update(User user);

	public void add(User user);

	public List<User> getAllUsers();

	public void remove(Integer id);

}
