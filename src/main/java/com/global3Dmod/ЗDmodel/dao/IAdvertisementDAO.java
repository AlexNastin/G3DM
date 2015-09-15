package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.Advertisement;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface IAdvertisementDAO {

	public void updateAdvertisement(Advertisement advertisement)
			throws DaoException;

	public void insertAdvertisement(Advertisement advertisement)
			throws DaoException;

	public List<Advertisement> selectAllAdvertisements() throws DaoException;

	public void deleteAdvertisement(Integer idAdvertisement)
			throws DaoException;
	
	public Advertisement selectAdvertisement(Integer idAdvertisement) throws DaoException;

}
