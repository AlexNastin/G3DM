package com.global3Dmod.ÇDmodels.dao;

import java.util.List;

import com.global3Dmod.ÇDmodels.domain.Like;
import com.global3Dmod.ÇDmodels.exception.DaoException;

public interface ILikeDAO {

	public void updateLike(Like like) throws DaoException;

	public void insertLike(Like like) throws DaoException;

	public List<Like> selectAllLikes() throws DaoException;

	public void deleteLike(Integer idLike) throws DaoException;

	public List<Like> selectLikeNotExists(Integer idUser, Integer idPost)
			throws DaoException;

	public int selectCountLikeByPost(Integer idPost) throws DaoException;
	
	public int selectCountLikeByAllPosts(Integer idUser) throws DaoException;
}
