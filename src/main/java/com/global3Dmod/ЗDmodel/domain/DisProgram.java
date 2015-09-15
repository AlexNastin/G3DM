package com.global3Dmod.ÇDmodel.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.global3Dmod.ÇDmodel.domain.Essence;

@Entity
@Table(name = "disprograms")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "informstatic")
@NamedQuery(name = "DisProgram.findAll", query = "select d from DisProgram d", hints = {
		@QueryHint(name = "org.hibernate.cacheable", value = "true") })
public class DisProgram implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3040870465375382020L;

	@Id
	@Column(name = "id_disprogram")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDisProgram;

	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "disProgram", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts;

	public DisProgram() {
		super();
	}

	public int getIdDisProgram() {
		return idDisProgram;
	}

	public void setIdDisProgram(int idDisProgram) {
		this.idDisProgram = idDisProgram;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDisProgram;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		DisProgram other = (DisProgram) obj;
		if (idDisProgram != other.idDisProgram)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DisProgram [idDisProgram=" + idDisProgram + ", title=" + title + "]";
	}

}
