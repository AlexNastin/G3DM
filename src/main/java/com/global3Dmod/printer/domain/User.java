package com.global3Dmod.printer.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.global3Dmod.printer.domain.Essence;

@Entity
@Table(name = "USERS")
@NamedQuery(name="User.findAll", query="select u from User u")
public class User implements Essence {


	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column(name = "role_idRole")
	private int role_idRole;

	@Column(name = "country_id—ountry")
	private int country_id—ountry;

	@Column(name = "city_id—ity")
	private int city_id—ity;

	@Column(name = "nickName")
	private String nickName;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "registrationDate")
	private Date registrationDate;

	@Column(name = "dateBirth")
	private Date dateBirth;

	@Column(name = "rating")
	private double rating;

	
	public User() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getRole_idRole() {
		return role_idRole;
	}

	public void setRole_idRole(int role_idRole) {
		this.role_idRole = role_idRole;
	}

	public int getCountry_id—ountry() {
		return country_id—ountry;
	}

	public void setCountry_id—ountry(int country_id—ountry) {
		this.country_id—ountry = country_id—ountry;
	}

	public int getCity_id—ity() {
		return city_id—ity;
	}

	public void setCity_id—ity(int city_id—ity) {
		this.city_id—ity = city_id—ity;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + city_id—ity;
		result = prime * result + country_id—ountry;
		result = prime * result
				+ ((dateBirth == null) ? 0 : dateBirth.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + role_idRole;
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
		User other = (User) obj;
		if (city_id—ity != other.city_id—ity)
			return false;
		if (country_id—ountry != other.country_id—ountry)
			return false;
		if (dateBirth == null) {
			if (other.dateBirth != null)
				return false;
		} else if (!dateBirth.equals(other.dateBirth))
			return false;
		if (idUser != other.idUser)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Double.doubleToLongBits(rating) != Double
				.doubleToLongBits(other.rating))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (role_idRole != other.role_idRole)
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
		return "User [idUser=" + idUser + ", role_idRole=" + role_idRole
				+ ", country_id—ountry=" + country_id—ountry + ", city_id—ity="
				+ city_id—ity + ", nickName=" + nickName + ", login=" + login
				+ ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", registrationDate=" + registrationDate
				+ ", dateBirth=" + dateBirth + ", rating=" + rating + "]";
	}

}
