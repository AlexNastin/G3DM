package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Avatars")
@NamedQuery(name="Avatar.findAll", query="select a from Avatar a")
public class Avatar implements Essence {

	@Id
	@Column(name = "idAvatar")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAvatar;

	@Column(name = "user_idUser")
	private int user_idUser;

	@Column(name = "avatarPath")
	private String avatarPath;

	public Avatar() {
		super();
	}

	public int getIdAvatar() {
		return idAvatar;
	}

	public void setIdAvatar(int idAvatar) {
		this.idAvatar = idAvatar;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((avatarPath == null) ? 0 : avatarPath.hashCode());
		result = prime * result + idAvatar;
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
		Avatar other = (Avatar) obj;
		if (avatarPath == null) {
			if (other.avatarPath != null)
				return false;
		} else if (!avatarPath.equals(other.avatarPath))
			return false;
		if (idAvatar != other.idAvatar)
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avatar [idAvatar=" + idAvatar + ", user_idUser=" + user_idUser
				+ ", avatarPath=" + avatarPath + "]";
	}

}
