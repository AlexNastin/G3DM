package com.global3Dmod.�Dmodel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.�Dmodel.dao.IFileDAO;
import com.global3Dmod.�Dmodel.domain.File;
import com.global3Dmod.�Dmodel.exception.DaoException;

@Repository("jpaFileDAO")
public class FileDAOImpl implements IFileDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "File" to the database
	 * 
	 * @param file
	 *            object of type "File"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertFile(File file) throws DaoException {
		em.persist(file);

	}

	/**
	 * Receipt of all elements of the table "files" from the database
	 * 
	 * @return file collection of objects of type "File"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<File> selectAllFiles() throws DaoException {
		List<File> file = em.createNamedQuery("File.findAll").getResultList();
		return file;
	}

	/**
	 * Delete the object of type "File" from the database
	 * 
	 * @param id
	 *            row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteFile(Integer id) throws DaoException {
		File file = em.find(File.class, id);
		em.remove(file);
	}

	/**
	 * Update the object of type "File" in the database
	 * 
	 * @param file
	 *            object of type "File"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateFile(File file) throws DaoException {
		em.merge(file);

	}

	@Override
	public File selectFileById(Integer idFile) throws DaoException {
		File file = (File) em.createNamedQuery("File.findFileById")
				.setParameter("idFile", idFile).getSingleResult();
		return file;

	}

}
