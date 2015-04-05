package com.global3Dmod.printer.dao.impl;

import com.global3Dmod.printer.dao.IUserDAO;

/**
 * 
 * This abstract class holds abstract methods for further implementation dao.
 * 
 * @author Alex Nastin
 */
public abstract class AbstractDAOFactory {

	public AbstractDAOFactory() {
	}

	public  IUserDAO getlUserDao() {
		return null;
	}

}