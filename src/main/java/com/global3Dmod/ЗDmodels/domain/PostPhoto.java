package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Table;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "POSTPHOTOS")
@NamedQuery(name="PostPhoto.findAll", query="select p from PostPhoto p")
public class PostPhoto implements Essence {

	@Id
	@Column(name = "idPostPhoto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPostPhoto;

	@Column(name = "photoPath")
	private String photoPath;
	
	@ManyToOne
	@JoinColumn(name = "idPost")
	private Post post;
	
	public PostPhoto() {
		super();
	}

	public int getIdPostPhoto() {
		return idPostPhoto;
	}

	public void setIdPostPhoto(int idPostPhoto) {
		this.idPostPhoto = idPostPhoto;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
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
		result = prime * result + idPostPhoto;
		result = prime * result
				+ ((photoPath == null) ? 0 : photoPath.hashCode());
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
		PostPhoto other = (PostPhoto) obj;
		if (idPostPhoto != other.idPostPhoto)
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostPhoto [idPostPhoto=" + idPostPhoto + ", photoPath=" + photoPath + "]";
	}

	

}
