package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IFileDAO;
import com.global3Dmod.ÇDmodels.domain.File;

@Component
@Repository("jpaFileDAO")
@Transactional
public class FileDAOImpl implements IFileDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(File file) {
		em.persist(file);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<File> getAllFiles() {
		List<File> file = em.createNamedQuery("File.findAll").getResultList();
		return file;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		File file = em.find(File.class, id);
		em.remove(file);
	}

	@Override
	@Transactional
	public void update(File file) {
		em.merge(file);
		
	}

}
