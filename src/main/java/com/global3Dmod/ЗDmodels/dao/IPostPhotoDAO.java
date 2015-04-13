package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.PostPhoto;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IPostPhotoDAO {
	
	public void update(PostPhoto postPhoto) throws DaoException;

	public void add(PostPhoto postPhoto) throws DaoException;

	public List<PostPhoto> getAllPostPhotos() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
