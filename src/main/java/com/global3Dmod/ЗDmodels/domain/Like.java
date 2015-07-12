package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
@NamedQueries({
		@NamedQuery(name = "Like.findAll", query = "select l from Like l"),
		@NamedQuery(name = "Like.findLikeByUser", query = "select l from Like l where l.user_idUser = :user_idUser and l.post_idPost = :post_idPost"),
		@NamedQuery(name = "Like.colLikeByPost", query = "SELECT COUNT(l.post_idPost) from Like l where l. post_idPost= :post_idPost") })
public class Like {

	@Id
	@Column(name = "id_like")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLike;

	@Column(name = "posts_id_post")
	private int post_idPost;

	@Column(name = "users_id_user")
	private int user_idUser;

	public int getIdLike() {
		return idLike;
	}

	public void setIdLike(int idLike) {
		this.idLike = idLike;
	}

	public int getPosts_idPost() {
		return post_idPost;
	}

	public void setPosts_idPost(int posts_idPost) {
		this.post_idPost = posts_idPost;
	}

	public int getUsers_idUser() {
		return user_idUser;
	}

	public void setUsers_idUser(int users_idUser) {
		this.user_idUser = users_idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLike;
		result = prime * result + post_idPost;
		result = prime * result + user_idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Like other = (Like) obj;
		if (idLike != other.idLike)
			return false;
		if (post_idPost != other.post_idPost)
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Like [idLike=" + idLike + ", posts_idPost=" + post_idPost
				+ ", users_idUser=" + user_idUser + "]";
	}

}
