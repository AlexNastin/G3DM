package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Printer;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IPrinterDAO {
	
	public void update(Printer printer) throws DaoException;

	public void add(Printer printer) throws DaoException;

	public List<Printer> getAllPrinters() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
