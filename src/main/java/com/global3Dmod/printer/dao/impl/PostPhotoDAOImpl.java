package com.global3Dmod.printer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.printer.dao.IPostPhotoDAO;
import com.global3Dmod.printer.domain.PostPhoto;

@Component
@Repository("jpaPostPhotoDAO")
@Transactional
public class PostPhotoDAOImpl implements IPostPhotoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(PostPhoto postPhoto) {
		em.persist(postPhoto);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PostPhoto> getAllPostPhotos() {
		List<PostPhoto> postPhoto = em.createNamedQuery("PostPhoto.findAll").getResultList();
		return postPhoto;
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		PostPhoto postPhoto = em.find(PostPhoto.class, id);
		em.remove(postPhoto);
	}

	@Override
	@Transactional
	public void update(PostPhoto postPhoto) {
		em.merge(postPhoto);
		
	}

}
