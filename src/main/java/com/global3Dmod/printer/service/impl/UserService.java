package com.global3Dmod.printer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global3Dmod.printer.dao.IUserDAO;
import com.global3Dmod.printer.domain.User;
import com.global3Dmod.printer.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDAO userDAO;

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}
