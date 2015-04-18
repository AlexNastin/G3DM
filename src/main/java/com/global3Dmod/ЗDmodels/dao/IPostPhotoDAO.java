package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.PostPhoto;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IPostPhotoDAO {
	
	public void updatePostPhoto(PostPhoto postPhoto) throws DaoException;

	public void insertPostPhoto(PostPhoto postPhoto) throws DaoException;

	public List<PostPhoto> selectAllPostPhotos() throws DaoException;

	public void deletePostPhoto(Integer id) throws DaoException;

}
