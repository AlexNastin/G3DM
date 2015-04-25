package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IPostPhotoDAO;
import com.global3Dmod.ÇDmodels.domain.PostPhoto;
import com.global3Dmod.ÇDmodels.exception.DaoException;


@Repository("jpaPostPhotoDAO")
@Transactional
public class PostPhotoDAOImpl implements IPostPhotoDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "PostPhoto" to the database
	 * @param postPhoto object of type "PostPhoto"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertPostPhoto(PostPhoto postPhoto) throws DaoException {
		em.persist(postPhoto);

	}

	/**
	 * Receipt of all elements of the table "postphotos" from the database
	 * @return postPhoto collection of objects of type "PostPhoto"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PostPhoto> selectAllPostPhotos() throws DaoException {
		List<PostPhoto> postPhoto = em.createNamedQuery("PostPhoto.findAll").getResultList();
		return postPhoto;
	}

	/**
	 * Delete the object of type "PostPhoto" from the database
	 * @param id row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deletePostPhoto(Integer id) throws DaoException {
		PostPhoto postPhoto = em.find(PostPhoto.class, id);
		em.remove(postPhoto);
	}

	/**
	 * Update the object of type "PostPhoto" in the database
	 * @param postPhoto object of type "PostPhoto"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updatePostPhoto(PostPhoto postPhoto) throws DaoException {
		em.merge(postPhoto);
		
	}

}
