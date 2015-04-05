package com.global3Dmod.printer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Votechecks")
public class Votecheck implements Essence {

	@Id
	@Column(name = "idVotecheck")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVotecheck;

	@Column(name = "post_idPost")
	private int post_idPost;

	@Column(name = "user_idUser")
	private int user_idUser;

	@Column(name = "isCheck")
	private boolean isCheck;

	public Votecheck() {
		super();
	}

	public int getIdVotecheck() {
		return idVotecheck;
	}

	public void setIdVotecheck(int idVotecheck) {
		this.idVotecheck = idVotecheck;
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

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVotecheck;
		result = prime * result + (isCheck ? 1231 : 1237);
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
		Votecheck other = (Votecheck) obj;
		if (idVotecheck != other.idVotecheck)
			return false;
		if (isCheck != other.isCheck)
			return false;
		if (post_idPost != other.post_idPost)
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Votecheck [idVotecheck=" + idVotecheck + ", post_idPost="
				+ post_idPost + ", user_idUser=" + user_idUser + ", isCheck="
				+ isCheck + "]";
	}

}
