package com.global3Dmod.«Dmodels.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.global3Dmod.«Dmodels.dao.IUserDAO;
import com.global3Dmod.«Dmodels.domain.User;
import com.global3Dmod.«Dmodels.exception.DaoException;
import com.global3Dmod.«Dmodels.exception.ServiceException;
import com.global3Dmod.«Dmodels.form.SignupForm;
import com.global3Dmod.«Dmodels.service.IGuestService;

@Service
public class GuestService implements IGuestService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public void addUser(SignupForm signupForm, User user)throws ServiceException {
		
		String md5Password = DigestUtils.md5Hex(signupForm.getPassword());
		
		user.setRole_idRole(signupForm.getRole_idRole());
		user.setCountry_id—ountry(ParamConstant.ID_—OUNTRY);
		user.setCity_id—ity(ParamConstant.ID_—ITY);
		user.setNickName(signupForm.getNickName());
		user.setLogin(signupForm.getLogin());
		user.setPassword(md5Password);
		user.setName(ParamConstant.EMPTY);
		user.setSurname(ParamConstant.EMPTY);
		user.setGender(ParamConstant.GENDER);
		
		

		try {
			userDAO.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}



}
