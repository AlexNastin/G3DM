package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.PostPhoto;

public interface IPostPhotoDAO {
	
	public void update(PostPhoto postPhoto);

	public void add(PostPhoto postPhoto);

	public List<PostPhoto> getAllPostPhotos();

	public void remove(Integer id);

}
