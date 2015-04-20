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

	@Override
	@Transactional
	public void insertPostPhoto(PostPhoto postPhoto) throws DaoException {
		em.persist(postPhoto);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PostPhoto> selectAllPostPhotos() throws DaoException {
		List<PostPhoto> postPhoto = em.createNamedQuery("PostPhoto.findAll").getResultList();
		return postPhoto;
	}

	@Override
	@Transactional
	public void deletePostPhoto(Integer id) throws DaoException {
		PostPhoto postPhoto = em.find(PostPhoto.class, id);
		em.remove(postPhoto);
	}

	@Override
	@Transactional
	public void updatePostPhoto(PostPhoto postPhoto) throws DaoException {
		em.merge(postPhoto);
		
	}

}
