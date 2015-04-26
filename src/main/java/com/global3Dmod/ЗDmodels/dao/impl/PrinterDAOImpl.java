package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.aop.annotation.AspectDaoG3DM;
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
	@AspectDaoG3DM
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
	@AspectDaoG3DM
	public List<Printer> selectAllPrinters() throws DaoException {
		List<Printer> printer = em.createNamedQuery("Printer.findAll").getResultList();
		return printer;
	}

	/**
	 * Delete the object of type "Printer" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	@AspectDaoG3DM
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
	@AspectDaoG3DM
	public void updatePrinter(Printer printer) throws DaoException {
		em.merge(printer);
		
	}

}
