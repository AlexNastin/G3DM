package com.global3Dmod.«Dmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@NamedQuery(name="—ountry.findAll", query="select c from Country c")
public class Country implements Essence {

	@Id
	@Column(name = "id_country")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id—ountry;

	@Column(name = "title")
	private String title;

	public Country() {
		super();
	}

	public int getId—ountry() {
		return id—ountry;
	}

	public void setId—ountry(int id—ountry) {
		this.id—ountry = id—ountry;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id—ountry;
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
		Country other = (Country) obj;
		if (id—ountry != other.id—ountry)
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
		return "—ountry [id—ountry=" + id—ountry + ", title=" + title + "]";
	}

}
