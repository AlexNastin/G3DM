package com.global3Dmod.�Dmodels.service;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.ServiceException;

public interface IUserService {

	public List<User> getAllUsers() throws ServiceException;

	public List<User> getTop3Users() throws ServiceException;
}
