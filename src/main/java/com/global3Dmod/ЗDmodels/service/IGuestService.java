package com.global3Dmod.�Dmodels.service;

import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.ServiceException;

public interface IGuestService {
	
	public void addUser(User user) throws ServiceException;

}
