package com.global3Dmod.ÇDmodels.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@NamedQueries({
	@NamedQuery(name="Country.findAll", query="select c from Country c"),
	@NamedQuery(name = "Country.findCountryById", query = "select c from Country c join fetch c.cities where c.idCountry = :idCountry")})
public class Country implements Essence {

	@Id
	@Column(name = "id_country")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCountry;

	@Column(name = "title")
	private String title;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> users;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<City> cities = new ArrayList<City>();

	public Country() {
		super();
	}

	public int getIdCountry() {
		return idCountry;
	}


	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCountry;
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
		if (idCountry != other.idCountry)
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
		return "Country [idCountry=" + idCountry + ", title=" + title
				+ ", users=" + users + ", cities=" + cities + "]";
	}

	

}
