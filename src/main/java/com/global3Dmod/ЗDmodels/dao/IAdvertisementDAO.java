package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Advertisement;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IAdvertisementDAO {

	public void updateAdvertisement(Advertisement advertisement)
			throws DaoException; // modifyAdvertisement

	public void insertAdvertisement(Advertisement advertisement)
			throws DaoException; // addAdvertisement

	public List<Advertisement> selectAllAdvertisements() throws DaoException; // getAllAdvertisements

	public void deleteAdvertisement(Integer idAdvertisement)
			throws DaoException; // removeAdvertisement

}
