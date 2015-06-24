package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "files")
@NamedQuery(name="File.findAll", query="select f from File f")
public class File implements Essence {
	
	@Id
	@Column(name = "id_file")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFile;

	@Column(name = "file_path")
	private String filePath;
	
	@OneToOne
	@JoinColumn(name = "post_id_post")
	private Post post;
	
	public File() {
		super();
	}

	public int getIdFile() {
		return idFile;
	}

	public void setIdFile(int idFile) {
		this.idFile = idFile;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
				+ ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + idFile;
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
		File other = (File) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (idFile != other.idFile)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "File [idFile=" + idFile + ", filePath=" + filePath + "]";
	}
	
	

}
