package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.User;

public interface IUserDAO {
	
	public void update(User user);

	public void add(User user);

	public List<User> getAllUsers();
	
	public List<User> getTop3Users();

	public void remove(Integer id);

}
