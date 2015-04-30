package com.global3Dmod.�Dmodels.dao;

import java.util.List;
import java.util.Set;

import com.global3Dmod.�Dmodels.domain.Printer;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IPrinterDAO {
	
	public void updatePrinter(Printer printer) throws DaoException;

	public void insertPrinter(Printer printer) throws DaoException;

	public List<Printer> selectAllPrinters() throws DaoException;
	
	public List<Printer> selectCheckPrintersById(String [] printersId) throws DaoException;

	public void deletePrinter(Integer id) throws DaoException;

}
