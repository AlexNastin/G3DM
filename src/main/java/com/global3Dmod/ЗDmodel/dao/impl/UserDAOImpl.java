package com.global3Dmod.ÇDmodel.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.global3Dmod.ÇDmodel.dao.IUserDAO;
import com.global3Dmod.ÇDmodel.domain.Post;
import com.global3Dmod.ÇDmodel.domain.User;
import com.global3Dmod.ÇDmodel.exception.DaoException;

@Repository("jpaUserDAO")
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Insert the object of type "User" to the database
	 * 
	 * @param user
	 *            object of type "User"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void insertUser(User user) throws DaoException {
		em.persist(user);

	}

	/**
	 * Receipt of all elements of the table "users" from the database
	 * 
	 * @return users collection of objects of type "User"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUsers() throws DaoException {
		List<User> users = em.createNamedQuery("User.findAll").getResultList();
		return users;
	}

	/**
	 * Delete the object of type "User" from the database
	 * 
	 * @param id
	 *            row ID in the database
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void deleteUser(Integer id) throws DaoException {
		User user = em.find(User.class, id);
		em.remove(user);
	}

	/**
	 * Update the object of type "User" in the database
	 * 
	 * @param user
	 *            object of type "User"
	 * @throws DaoException
	 * */
	@Override
	@Transactional
	public void updateUser(User user) throws DaoException {
		em.merge(user);

	}

	/**
	 * Receipt of all user`s email address of the table "users" from the
	 * database
	 * 
	 * @return emails collection of objects of type "String"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectAllEmail() throws DaoException {
		List<String> emails = em.createNamedQuery("User.findAllEmail")
				.getResultList();
		return emails;
	}

	/**
	 * Receipt of all user`s nickname of the table "users" from the database
	 * 
	 * @return nickNames collection of objects of type "String"
	 * @throws DaoException
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectAllNickName() throws DaoException {
		List<String> nickNames = em.createNamedQuery("User.findAllNickName")
				.getResultList();
		return nickNames;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User selectUser(String login) throws DaoException {
		List<User> users = em.createNamedQuery("User.findUserByLogin").setParameter("login", login).getResultList();
		User user = null;
		if (!users.isEmpty()) {
			user = users.get(0);
		}
		
		return user;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User selectUserWithCountry(String login) throws DaoException {
		List<User> users = em.createNamedQuery("User.findUserByLoginWithCountry").setParameter("login", login).getResultList();
		User user = null;
		if (!users.isEmpty()) {
			user = users.get(0);
		}
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User selectUserById(Integer id) throws DaoException {
		User user = (User) em.createNamedQuery("User.findUserById")
				.setParameter("idUser", id).getSingleResult();
		List<Post> posts = em.createNamedQuery("Post.findByDesignerPublished").setParameter("idUser", id).getResultList();
		user.setPosts(posts);
		return user;
	}

	@Override
	public User selectUserByIdWithoutAll(Integer id) throws DaoException {
		User user = (User) em.createNamedQuery("User.findUserByIdWithoutAll")
				.setParameter("idUser", id).getSingleResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectModeratorsForSort() throws DaoException {
		List<User> users = em.createNamedQuery("User.findModerators").getResultList();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectDesignersForSort() throws DaoException {
		List<User> users = em.createNamedQuery("User.findDesigners").getResultList();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectUsersForSort() throws DaoException {
		List<User> users = em.createNamedQuery("User.findUsers").getResultList();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectTop4ByRating() throws DaoException {
		List<User> users = em.createNamedQuery("User.findTop4ByRating").setMaxResults(4).getResultList();
		return users;
	}

	@Override
	public int selectNumberOfAllUsers() throws DaoException {
		long resut = (long) em.createNamedQuery("User.numberOfAllUsers").getSingleResult();
		int allUsers = (int) resut;
		return allUsers;
	}

	@Override
	public int selectNumberOfDesigners() throws DaoException {
		long resut = (long) em.createNamedQuery("User.numberOfDesigners").getSingleResult();
		int designers = (int) resut;
		return designers;
	}

	@Override
	public int selectNumberOfModerators() throws DaoException {
		long resut = (long) em.createNamedQuery("User.numberOfModerators").getSingleResult();
		int moderators = (int) resut;
		return moderators;
	}

	@Override
	public int selectNumberOfUsers() throws DaoException {
		long resut = (long) em.createNamedQuery("User.numberOfUsers").getSingleResult();
		int users = (int) resut;
		return users;
	}

	@Override
	public int selectNumberOfAdmins() throws DaoException {
		long resut = (long) em.createNamedQuery("User.numberOfAdmins").getSingleResult();
		int admins = (int) resut;
		return admins;
	}

}
