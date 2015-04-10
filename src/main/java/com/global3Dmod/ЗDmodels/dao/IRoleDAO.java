package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Role;

public interface IRoleDAO {
	
	public void update(Role role);

	public void add(Role role);

	public List<Role> getAllRoles();

	public void remove(Integer id);

}
