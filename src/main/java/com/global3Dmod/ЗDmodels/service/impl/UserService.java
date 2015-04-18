package com.global3Dmod.�Dmodels.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global3Dmod.�Dmodels.dao.IUserDAO;
import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.DaoException;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	public List<User> getAllUsers() throws ServiceException {
		List<User> users = null;

		try {
			users = userDAO.selectAllUsers();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return users;
	}

	@Override
	public List<User> getTop3Users() {
		List<User> users = null;
		try {
			userDAO.selectTop3Users();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

}
