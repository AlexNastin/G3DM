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

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "files")
@NamedQueries({
		@NamedQuery(name = "File.findAll", query = "select f from File f"),
		@NamedQuery(name = "File.findFileById", query = "select f from File f where f.idFile = :idFile")})
public class File implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3872172969551746192L;

	@Id
	@Column(name = "id_file")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFile;

	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "folder")
	private long folder;
	
	@Column(name = "file_name")
	private String fileName;

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
		result = prime * result
				+ ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + (int) (folder ^ (folder >>> 32));
		result = prime * result + idFile;
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
		File other = (File) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (folder != other.folder)
			return false;
		if (idFile != other.idFile)
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
		return "File [idFile=" + idFile + ", filePath=" + filePath
				+ ", folder=" + folder + ", fileName=" + fileName + "]";
	}

	
}
