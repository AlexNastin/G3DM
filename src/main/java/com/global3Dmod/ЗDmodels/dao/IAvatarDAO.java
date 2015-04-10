package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Avatar;

public interface IAvatarDAO {
	
	public void update(Avatar avatar);

	public void add(Avatar avatar);

	public List<Avatar> getAllAvatars();

	public void remove(Integer id);

}
