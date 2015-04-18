package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IFileDAO;
import com.global3Dmod.ÇDmodels.domain.File;


@Repository("jpaFileDAO")
@Transactional
public class FileDAOImpl implements IFileDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertFile(File file) {
		em.persist(file);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<File> selectAllFiles() {
		List<File> file = em.createNamedQuery("File.findAll").getResultList();
		return file;
	}

	@Override
	@Transactional
	public void deleteFile(Integer id) {
		File file = em.find(File.class, id);
		em.remove(file);
	}

	@Override
	@Transactional
	public void updateFile(File file) {
		em.merge(file);
		
	}

}
