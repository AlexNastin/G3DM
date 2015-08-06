package com.global3Dmod.ÇDmodels.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodels.dao.IAdvertisementDAO;
import com.global3Dmod.ÇDmodels.domain.Advertisement;
import com.global3Dmod.ÇDmodels.exception.DaoException;

@Repository("jpaAdvertisementDAO")
@Transactional
public class AdvertisementDAOImpl implements IAdvertisementDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "Advertisement" to the database
	 * 
	 * @param avatar
	 *            object of type "Advertisement"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertAdvertisement(Advertisement advertisement)
			throws DaoException {
		em.persist(advertisement);
	}

	/**
	 * Receipt of all elements of the table "advertisements" from the database
	 * 
	 * @return Advertisement collection of objects of type "Advertisement"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Advertisement> selectAllAdvertisements() throws DaoException {
		List<Advertisement> advertisements = em.createNamedQuery(
				"Advertisement.findAll").getResultList();
		return advertisements;
	}

	/**
	 * Delete the object of type "Advertisement" from the database
	 * 
	 * @param id
	 *            row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteAdvertisement(Integer idAdvertisement)
			throws DaoException {
		Advertisement advertisement = em.find(Advertisement.class,
				idAdvertisement);
		em.remove(advertisement);

	}

	/**
	 * Update the object of type "Advertisement" in the database
	 * 
	 * @param advertisement
	 *            object of type "Advertisement"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateAdvertisement(Advertisement advertisement)
			throws DaoException {
		em.merge(advertisement);
	}

	@Override
	@Transactional
	public Advertisement selectAdvertisement(Integer idAdvertisement)
			throws DaoException {
		Advertisement advertisement = (Advertisement) em.createNamedQuery("Advertisement.findOneById")
				.setParameter("idAdvertisement", idAdvertisement).getSingleResult();
		return advertisement;
	}

}
