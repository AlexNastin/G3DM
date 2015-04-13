package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Role;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IRoleDAO {
	
	public void update(Role role) throws DaoException;

	public void add(Role role) throws DaoException;

	public List<Role> getAllRoles() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
