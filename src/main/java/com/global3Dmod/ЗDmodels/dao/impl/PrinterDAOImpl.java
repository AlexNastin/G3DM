package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@Override
	@Transactional
	public void insertPrinter(Printer printer) throws DaoException {
		em.persist(printer);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Printer> selectAllPrinters() throws DaoException {
		List<Printer> printer = em.createNamedQuery("Printer.findAll").getResultList();
		return printer;
	}

	@Override
	@Transactional
	public void deletePrinter(Integer id) throws DaoException {
		Printer printer = em.find(Printer.class, id);
		em.remove(printer);
	}

	@Override
	@Transactional
	public void updatePrinter(Printer printer) throws DaoException {
		em.merge(printer);
		
	}

}
