package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "avatars")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Avatar.findAll", query = "select a from Avatar a") })
public class Avatar implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343695704915602325L;

	@Id
	@Column(name = "id_avatar")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAvatar;

	@Column(name = "avatar_path")
	private String avatarPath;

	@Column(name = "file_name")
	private String fileName;

	@OneToOne
	@JoinColumn(name = "user_id_user")
	private User user;

	public Avatar() {
		super();
	}

	public int getIdAvatar() {
		return idAvatar;
	}

	public void setIdAvatar(int idAvatar) {
		this.idAvatar = idAvatar;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarPath == null) ? 0 : avatarPath.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + idAvatar;
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
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (idAvatar != other.idAvatar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avatar [idAvatar=" + idAvatar + ", avatarPath=" + avatarPath + ", fileName=" + fileName + "]";
	}

}
