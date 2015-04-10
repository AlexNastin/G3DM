package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Blacklist;

public interface IBlacklistDAO {
	
	public void update(Blacklist blacklist);

	public void add(Blacklist blacklist);

	public List<Blacklist> getAllBlacklists();

	public void remove(Integer id);

}
