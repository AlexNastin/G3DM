package com.global3Dmod.�Dmodels.service;

import com.global3Dmod.�Dmodels.domain.User;
import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.SignupForm;

public interface IGuestService {
	
	public void addUser(SignupForm signupForm, User user) throws ServiceException;

}
