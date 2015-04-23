package com.global3Dmod.ÇDmodels.exception;

/**
 * This exception appears from DAO.
 * 
 * @author Alex Nastin
 */
public class ValidatorException extends ProjectException {

	private static final long serialVersionUID = 1395030963234802420L;

	public ValidatorException(String message) {
		super(message);

	}

	public ValidatorException(String message, Throwable e) {
		super(message, e);
	}

	public ValidatorException(Throwable e) {
		super(e);
	}
}
