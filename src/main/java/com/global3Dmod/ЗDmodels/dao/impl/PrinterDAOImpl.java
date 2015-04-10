package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IPrinterDAO;
import com.global3Dmod.ÇDmodels.domain.Printer;

@Component
@Repository("jpaPrinterDAO")
@Transactional
public class PrinterDAOImpl implements IPrinterDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Printer printer) {
		em.persist(printer);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Printer> getAllPrinters() {
		List<Printer> printer = em.createNamedQuery("Printer.findAll").getResultList();
		return printer;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Printer printer = em.find(Printer.class, id);
		em.remove(printer);
	}

	@Override
	@Transactional
	public void update(Printer printer) {
		em.merge(printer);
		
	}

}
