package com.global3Dmod.ÇDmodel.exception;

/**
 * This exception appears from All project.
 * 
 * @author Alex Nastin
 */
public class ProjectException extends Exception {

	private static final long serialVersionUID = 1395030963234802420L;

	public ProjectException(String message) {
		super(message);

	}

	public ProjectException(String message, Throwable e) {
		super(message, e);
	}

	public ProjectException(Throwable e) {
		super(e);
	}

}
