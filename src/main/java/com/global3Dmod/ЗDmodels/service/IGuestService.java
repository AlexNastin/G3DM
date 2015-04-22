package com.global3Dmod.ÇDmodels.service;

import com.global3Dmod.ÇDmodels.domain.User;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.form.SignupForm;

public interface IGuestService {
	
	public void addUser(SignupForm signupForm, User user) throws ServiceException;

}
