package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Printer;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IPrinterDAO {
	
	public void updatePrinter(Printer printer) throws DaoException;

	public void insertPrinter(Printer printer) throws DaoException;

	public List<Printer> selectAllPrinters() throws DaoException;

	public void deletePrinter(Integer id) throws DaoException;

}
