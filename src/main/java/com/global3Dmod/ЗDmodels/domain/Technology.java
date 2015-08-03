package com.global3Dmod.ÇDmodels.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "technology")
@NamedQueries({
	@NamedQuery(name="Technology.findAll", query="select t from Technology t"),
	@NamedQuery(name="Technology.findCheckById", query="select t from Technology t where t.idTechnology in (:idTechnology)") })
public class Technology implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4730556672346546546L;

	@Id
	@Column(name = "id_technology")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTechnology;
	
	@Column(name = "title")
	private String title;
	
	@ManyToMany(mappedBy="technologies")
	private List<Post> posts;
	
	public Technology() {
		super();
	}

	public int getIdTechnology() {
		return idTechnology;
	}



	public void setIdTechnology(int idTechnology) {
		this.idTechnology = idTechnology;
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
		result = prime * result + idTechnology;
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
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
		Technology other = (Technology) obj;
		if (idTechnology != other.idTechnology)
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
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
		return "Technology [idTechnology=" + idTechnology + ", title=" + title
				+ ", posts=" + posts + "]";
	}

	
	

}
