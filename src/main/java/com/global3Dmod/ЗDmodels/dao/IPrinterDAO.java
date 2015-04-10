package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Printer;

public interface IPrinterDAO {
	
	public void update(Printer printer);

	public void add(Printer printer);

	public List<Printer> getAllPrinters();

	public void remove(Integer id);

}
