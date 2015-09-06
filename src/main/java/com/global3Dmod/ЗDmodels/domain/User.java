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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.global3Dmod.«Dmodels.domain.Essence;

@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = "User.findTop3", query = "select u from User u order by u.rating desc"),
		@NamedQuery(name = "User.findAll", query = "select u from User u"),
		@NamedQuery(name = "User.findAllEmail", query = "select u.login from User u"),
		@NamedQuery(name = "User.findAllNickName", query = "select u.nickName from User u"),
		@NamedQuery(name = "User.findUserByLogin", query = "select u from User u where u.login = :login"),
		@NamedQuery(name = "User.findUserById", query = "select u from User u where u.idUser = :idUser"),
		@NamedQuery(name = "User.findModerators", query = "select u from User u where u.role_idRole = 4"),
		@NamedQuery(name = "User.findDesigners", query = "select u from User u where u.role_idRole = 3"),
		@NamedQuery(name = "User.findUsers", query = "select u from User u where u.role_idRole = 2"),
		@NamedQuery(name = "User.findTop4ByRating", query = "select u from User u join fetch u.avatar where u.role_idRole = 3 order by u.rating desc"),
		@NamedQuery(name = "User.numberOfAllUsers", query = "select count(u.idUser) from User u"),
		@NamedQuery(name = "User.numberOfDesigners", query = "select count(u.idUser) from User u where u.role_idRole = 3"),
		@NamedQuery(name = "User.numberOfModerators", query = "select count(u.idUser) from User u where u.role_idRole = 4"),
		@NamedQuery(name = "User.numberOfUsers", query = "select count(u.idUser) from User u where u.role_idRole = 2"),
		@NamedQuery(name = "User.numberOfAdmins", query = "select count(u.idUser) from User u where u.role_idRole = 1")})

public class User implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 951675885861940220L;

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	@Column(name = "role_id_role")
	private int role_idRole;

	@Column(name = "country_id_country")
	private int country_idCountry;

	@Column(name = "city_id_city")
	private int city_id—ity;

	@Column(name = "nick_name")
	private String nickName;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "gender")
	private int gender;

	@Column(name = "registration_date")
	private String registrationDate;

	@Column(name = "date_birth")
	private String dateBirth;

	@Column(name = "rating")
	private double rating;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id_country", insertable=false, updatable=false)
	private Country country;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id_city", insertable=false, updatable=false)
	private City city;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RejectMessage> rejectMessages;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Avatar avatar;

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

	public int getCountry_idCountry() {
		return country_idCountry;
	}

	public void setCountry_idCountry(int country_idCountry) {
		this.country_idCountry = country_idCountry;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<RejectMessage> getRejectMessages() {
		return rejectMessages;
	}

	public void setRejectMessages(List<RejectMessage> rejectMessages) {
		this.rejectMessages = rejectMessages;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + city_id—ity;
		result = prime * result + country_idCountry;
		result = prime * result
				+ ((dateBirth == null) ? 0 : dateBirth.hashCode());
		result = prime * result + gender;
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
		if (country_idCountry != other.country_idCountry)
			return false;
		if (dateBirth == null) {
			if (other.dateBirth != null)
				return false;
		} else if (!dateBirth.equals(other.dateBirth))
			return false;
		if (gender != other.gender)
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
				+ ", country_idCountry=" + country_idCountry + ", city_id—ity="
				+ city_id—ity + ", nickName=" + nickName + ", login=" + login
				+ ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", gender=" + gender + ", registrationDate="
				+ registrationDate + ", dateBirth=" + dateBirth + ", rating="
				+ rating + "]";
	}

	

	
	
}
