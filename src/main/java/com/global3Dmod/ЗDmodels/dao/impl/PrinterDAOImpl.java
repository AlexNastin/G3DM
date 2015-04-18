package com.global3Dmod.�Dmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodels.dao.IPrinterDAO;
import com.global3Dmod.�Dmodels.domain.Printer;


@Repository("jpaPrinterDAO")
@Transactional
public class PrinterDAOImpl implements IPrinterDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertPrinter(Printer printer) {
		em.persist(printer);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Printer> selectAllPrinters() {
		List<Printer> printer = em.createNamedQuery("Printer.findAll").getResultList();
		return printer;
	}

	@Override
	@Transactional
	public void deletePrinter(Integer id) {
		Printer printer = em.find(Printer.class, id);
		em.remove(printer);
	}

	@Override
	@Transactional
	public void updatePrinter(Printer printer) {
		em.merge(printer);
		
	}

}
