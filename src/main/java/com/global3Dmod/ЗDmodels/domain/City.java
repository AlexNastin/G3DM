package com.global3Dmod.«Dmodels.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
@NamedQuery(name="—ity.findAll", query="select c from City c")
public class City implements Essence {

	@Id
	@Column(name = "id_city")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCity;

	@Column(name = "country_id_country")
	private int country_idCountry;

	@Column(name = "title")
	private String title;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> users;
	
	@JoinColumn(name = "country_id_country", referencedColumnName = "id_country", insertable=false, updatable=false)
	@ManyToOne(optional = false)
	private Country country;

	public City() {
		super();
	}

	public int getIdCity() {
		return idCity;
	}



	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}



	public int getCountry_idCountry() {
		return country_idCountry;
	}

	public void setCountry_idCountry(int country_idCountry) {
		this.country_idCountry = country_idCountry;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + country_idCountry;
		result = prime * result + idCity;
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
		City other = (City) obj;
		if (country_idCountry != other.country_idCountry)
			return false;
		if (idCity != other.idCity)
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
		return "City [id—ity=" + idCity + ", country_idCountry="
				+ country_idCountry + ", title=" + title + ", users=" + users
				+ ", country=" + country + "]";
	}



}
