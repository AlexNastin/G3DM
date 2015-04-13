package com.global3Dmod.ÇDmodels.service;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;

public interface IUserService {

	public List<User> getAllUsers() throws ServiceException;

	public List<User> getTop3Users() throws ServiceException;
}
