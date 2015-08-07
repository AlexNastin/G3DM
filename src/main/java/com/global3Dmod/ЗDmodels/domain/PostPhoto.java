package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "postphotos")
@NamedQuery(name="PostPhoto.findAll", query="select p from PostPhoto p")
public class PostPhoto implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 391232760364429804L;

	@Id
	@Column(name = "id_postphoto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPostPhoto;

	@Column(name = "photo_path")
	private String photoPath;
	
	@Column(name = "folder")
	private long folder;
	
	@Column(name = "file_name")
	private String fileName;
	
	@ManyToOne
	@JoinColumn(name = "post_id_post")
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
	
	public long getFolder() {
		return folder;
	}

	public void setFolder(long folder) {
		this.folder = folder;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + (int) (folder ^ (folder >>> 32));
		result = prime * result + idPostPhoto;
		result = prime * result
				+ ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
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
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (folder != other.folder)
			return false;
		if (idPostPhoto != other.idPostPhoto)
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostPhoto [idPostPhoto=" + idPostPhoto + ", photoPath="
				+ photoPath + ", folder=" + folder + ", fileName=" + fileName
				+ "]";
	}

	

}
