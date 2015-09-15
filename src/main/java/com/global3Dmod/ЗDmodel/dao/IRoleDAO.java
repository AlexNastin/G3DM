package com.global3Dmod.ÇDmodel.dao;

import java.util.List;

import com.global3Dmod.ÇDmodel.domain.Role;
import com.global3Dmod.ÇDmodel.exception.DaoException;

public interface IRoleDAO {
	
	public void updateRole(Role role) throws DaoException;

	public void insertRole(Role role) throws DaoException;

	public List<Role> selectAllRoles() throws DaoException;

	public void deleteRole(Integer id) throws DaoException;

}
