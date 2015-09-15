package com.global3Dmod.�Dmodel.dao;

import java.util.List;

import com.global3Dmod.�Dmodel.domain.Complain;
import com.global3Dmod.�Dmodel.exception.DaoException;

public interface IComplainDAO {

	public void updateComplain(Complain complain) throws DaoException;

	public void insertComplain(Complain complain) throws DaoException;

	public List<Complain> selectAllComplains() throws DaoException;

	public void deleteComplain(Integer idComplain) throws DaoException;

	public List<Complain> selectComplainNotExists(Integer idUser, Integer idPost)
			throws DaoException;

	public int selectCountComplainByPost(Integer idPost) throws DaoException;
	
	public int selectCountComplainByAllPosts(Integer idUser) throws DaoException;
	
	public void deleteComplains(Integer idPost) throws DaoException;
}
