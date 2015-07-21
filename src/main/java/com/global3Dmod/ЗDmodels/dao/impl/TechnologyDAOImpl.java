package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IPrinterDAO;
import com.global3Dmod.ÇDmodels.domain.Printer;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaPrinterDAO")
@Transactional
public class PrinterDAOImpl implements IPrinterDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Printer" to the database
	 * @param printer object of type "Printer"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertPrinter(Printer printer) throws DaoException {
		em.persist(printer);

	}

	/**
	 * Receipt of all elements of the table "printers" from the database
	 * @return printer collection of objects of type "Printer"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Printer> selectAllPrinters() throws DaoException {
		List<Printer> printer = em.createNamedQuery("Printer.findAll").getResultList();
		return printer;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Printer> selectCheckPrintersById(String []printersId) throws DaoException {
		List<Integer> listIdPrinter = new ArrayList<Integer>();
		for (String printerId : printersId) {
			listIdPrinter.add(Integer.parseInt(printerId));
		}
		List<Printer> printer = em.createNamedQuery("Printer.findCheckById").setParameter("idPrinters", listIdPrinter).getResultList();
		return printer;
	}

	/**
	 * Delete the object of type "Printer" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deletePrinter(Integer id) throws DaoException {
		Printer printer = em.find(Printer.class, id);
		em.remove(printer);
	}

	/**
	 * Update the object of type "Printer" in the database
	 * @param printer object of type "Printer"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updatePrinter(Printer printer) throws DaoException {
		em.merge(printer);
		
	}

}
