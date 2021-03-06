package com.global3Dmod.�Dmodel.form;

import org.springframework.web.multipart.MultipartFile;

import com.global3Dmod.�Dmodel.domain.Essence;

public class UserPersonalDataForm implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8758516680145772843L;
	
	private int country_idCountry;
	private int city_idCity;
	private String name;
	private String surname;
	private int gender;
	private String dateBirth;
	
	// file
	private MultipartFile avatar;
	
	public UserPersonalDataForm() {
		super();
	}

	public int getCountry_idCountry() {
		return country_idCountry;
	}

	public void setCountry_idCountry(int country_idCountry) {
		this.country_idCountry = country_idCountry;
	}

	public int getCity_idCity() {
		return city_idCity;
	}

	public void setCity_idCity(int city_idCity) {
		this.city_idCity = city_idCity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + city_idCity;
		result = prime * result + country_idCountry;
		result = prime * result
				+ ((dateBirth == null) ? 0 : dateBirth.hashCode());
		result = prime * result + gender;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		UserPersonalDataForm other = (UserPersonalDataForm) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (city_idCity != other.city_idCity)
			return false;
		if (country_idCountry != other.country_idCountry)
			return false;
		if (dateBirth == null) {
			if (other.dateBirth != null)
				return false;
		} else if (!dateBirth.equals(other.dateBirth))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserPersonalDataForm [country_idCountry=" + country_idCountry
				+ ", city_idCity=" + city_idCity + ", name=" + name
				+ ", surname=" + surname + ", gender=" + gender
				+ ", dateBirth=" + dateBirth + ", avatar=" + avatar + "]";
	}

	
}
