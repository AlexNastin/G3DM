package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "complains")
@NamedQueries({
		@NamedQuery(name = "Complain.findAll", query = "select c from Complain c"),
		@NamedQuery(name = "Complain.findComplainByUser", query = "select c from Complain c where c.user_idUser = :user_idUser and c.post_idPost = :post_idPost"),
		@NamedQuery(name = "Complain.colComplainByPost", query = "SELECT COUNT(c.post_idPost) from Complain c where c.post_idPost= :post_idPost"),
		@NamedQuery(name = "Complain.colComplainByAllPosts", query = "SELECT COUNT(c.post_idPost) from Complain c where c.post_idPost in (select p.idPost from Post p where p.user_idUser = :user_idUser)")})

public class Complain implements Essence{

	@Id
	@Column(name = "id_complain")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComplain;

	@Column(name = "posts_id_post")
	private int post_idPost;

	@Column(name = "users_id_user")
	private int user_idUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "posts_id_post", insertable=false, updatable=false)
	private Post post;

	public int getIdComplain() {
		return idComplain;
	}

	public void setIdComplain(int idComplain) {
		this.idComplain = idComplain;
	}

	public int getPost_idPost() {
		return post_idPost;
	}

	public void setPost_idPost(int post_idPost) {
		this.post_idPost = post_idPost;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idComplain;
		result = prime * result + ((post == null) ? 0 : post.hashCode());
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
		Complain other = (Complain) obj;
		if (idComplain != other.idComplain)
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (post_idPost != other.post_idPost)
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Complain [idComplain=" + idComplain + ", post_idPost="
				+ post_idPost + ", user_idUser=" + user_idUser + "]";
	}

	

}
