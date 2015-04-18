package com.global3Dmod.�Dmodels.dao;

import java.util.List;

import com.global3Dmod.�Dmodels.domain.Role;
import com.global3Dmod.�Dmodels.exception.DaoException;

public interface IRoleDAO {
	
	public void updateRole(Role role) throws DaoException;

	public void insertRole(Role role) throws DaoException;

	public List<Role> selectAllRoles() throws DaoException;

	public void deleteRole(Integer id) throws DaoException;

}
