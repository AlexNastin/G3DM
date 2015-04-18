package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IPostPhotoDAO;
import com.global3Dmod.ÇDmodels.domain.PostPhoto;


@Repository("jpaPostPhotoDAO")
@Transactional
public class PostPhotoDAOImpl implements IPostPhotoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insertPostPhoto(PostPhoto postPhoto) {
		em.persist(postPhoto);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PostPhoto> selectAllPostPhotos() {
		List<PostPhoto> postPhoto = em.createNamedQuery("PostPhoto.findAll").getResultList();
		return postPhoto;
	}

	@Override
	@Transactional
	public void deletePostPhoto(Integer id) {
		PostPhoto postPhoto = em.find(PostPhoto.class, id);
		em.remove(postPhoto);
	}

	@Override
	@Transactional
	public void updatePostPhoto(PostPhoto postPhoto) {
		em.merge(postPhoto);
		
	}

}
