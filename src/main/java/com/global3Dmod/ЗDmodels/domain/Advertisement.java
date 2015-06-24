package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "advertisement")
@NamedQuery(name="Advertisement.findAll", query="select a from Advertisement a")
public class Advertisement implements Essence {

	@Id
	@Column(name = "id_advertisement")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdvertisement;

	@Column(name = "title")
	private String title;

	@Column(name = "path")
	private String path;

	@Column(name = "description")
	private String description;

	public Advertisement() {
	}

	public int getIdAdvertisement() {
		return idAdvertisement;
	}

	public void setIdAdvertisement(int idAdvertisement) {
		this.idAdvertisement = idAdvertisement;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idAdvertisement;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		Advertisement other = (Advertisement) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idAdvertisement != other.idAdvertisement)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
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
		return "Advertisement [idAdvertisement=" + idAdvertisement + ", title="
				+ title + ", path=" + path + ", description=" + description
				+ "]";
	}

}
