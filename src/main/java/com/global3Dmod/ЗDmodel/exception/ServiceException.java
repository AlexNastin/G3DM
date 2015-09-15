package com.global3Dmod.ÇDmodel.exception;

public class ServiceException extends ProjectException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6087234584288438561L;

	public ServiceException(String message) {
		super(message);

	}

	public ServiceException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceException(Throwable e) {
		super(e);
	}
}
