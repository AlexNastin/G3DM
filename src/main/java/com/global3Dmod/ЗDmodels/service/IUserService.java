package com.global3Dmod.�Dmodels.service;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public List<User> getTop3Users();
}
