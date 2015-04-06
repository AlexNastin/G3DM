package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.Role;

public interface IRoleDAO {
	
	public void update(Role role);

	public void add(Role role);

	public List<Role> getAllRoles();

	public void remove(Integer id);

}
