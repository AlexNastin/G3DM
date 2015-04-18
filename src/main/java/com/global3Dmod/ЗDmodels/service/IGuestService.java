package com.global3Dmod.ÇDmodels.service;

import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;

public interface IGuestService {
	
	public void addUser(User user) throws ServiceException;

}
