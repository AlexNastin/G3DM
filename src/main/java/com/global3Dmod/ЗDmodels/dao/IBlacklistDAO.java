package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Blacklist;

public interface IBlacklistDAO {
	
	public void update(Blacklist blacklist);

	public void add(Blacklist blacklist);

	public List<Blacklist> getAllBlacklists();

	public void remove(Integer id);

}
