package com.global3Dmod.�Dmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodels.dao.IFileDAO;
import com.global3Dmod.�Dmodels.domain.File;
import com.global3Dmod.�Dmodels.exception.DaoException;


@Repository("jpaFileDAO")
@Transactional
public class FileDAOImpl implements IFileDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertFile(File file) throws DaoException {
		em.persist(file);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<File> selectAllFiles() throws DaoException {
		List<File> file = em.createNamedQuery("File.findAll").getResultList();
		return file;
	}

	@Override
	@Transactional
	public void deleteFile(Integer id) throws DaoException {
		File file = em.find(File.class, id);
		em.remove(file);
	}

	@Override
	@Transactional
	public void updateFile(File file) throws DaoException {
		em.merge(file);
		
	}

}
