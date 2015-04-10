package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Avatar;

public interface IAvatarDAO {
	
	public void update(Avatar avatar);

	public void add(Avatar avatar);

	public List<Avatar> getAllAvatars();

	public void remove(Integer id);

}
