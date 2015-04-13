package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Role;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface IRoleDAO {
	
	public void update(Role role) throws DaoException;

	public void add(Role role) throws DaoException;

	public List<Role> getAllRoles() throws DaoException;

	public void remove(Integer id) throws DaoException;

}
