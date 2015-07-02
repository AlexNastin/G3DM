package com.global3Dmod.�Dmodels.form;

import com.global3Dmod.�Dmodels.domain.Essence;

public class PersonalDataForm implements Essence {
	
	private int country_idCountry;
	private int city_idCity;
	private String password;
	private String confirmPassword;
	private String name;
	private String surname;
	private int gender;
	private String dateBirth;

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

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + city_idCity;
		result = prime * result
				+ ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + country_idCountry;
		result = prime * result
				+ ((dateBirth == null) ? 0 : dateBirth.hashCode());
		result = prime * result + gender;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
		PersonalDataForm other = (PersonalDataForm) obj;
		if (city_idCity != other.city_idCity)
			return false;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "PersonalDataForm [country_idCountry=" + country_idCountry
				+ ", city_idCity=" + city_idCity + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", name=" + name
				+ ", surname=" + surname + ", gender=" + gender
				+ ", dateBirth=" + dateBirth + "]";
	}

	


	
}
