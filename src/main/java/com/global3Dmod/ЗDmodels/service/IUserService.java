package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public List<User> getTop3Users();
}
