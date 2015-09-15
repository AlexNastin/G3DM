package com.global3Dmod.ÇDmodel.exception;

/**
 * This exception appears from DAO.
 * 
 * @author Alex Nastin
 */
public class DaoException extends ProjectException {

	private static final long serialVersionUID = 1395030963234802420L;

	public DaoException(String message) {
		super(message);

	}

	public DaoException(String message, Throwable e) {
		super(message, e);
	}

	public DaoException(Throwable e) {
		super(e);
	}
}
