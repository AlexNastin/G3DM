package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.User;

public interface IUserDAO {
	
	public void update(User user);

	public void add(User user);

	public List<User> getAllUsers();
	
	public List<User> getTop3Users();

	public void remove(Integer id);

}
