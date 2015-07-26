package com.global3Dmod.ÇDmodels.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "password_reset_token")

@NamedQueries({
	@NamedQuery(name="PasswordResetToken.findAll", query="select p from PasswordResetToken p"),
	@NamedQuery(name = "PasswordResetToken.findTokenByUser", query = "select p from PasswordResetToken p where p.user_idUser = :user_idUser"),
	@NamedQuery(name = "PasswordResetToken.findTokenByToken", query = "select p from PasswordResetToken p where p.token = :token")})
public class PasswordResetToken {

	private static final int EXPIRATION = 60 * 24;

	@Id
	@Column(name = "id_token")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idToken;

	@Column(name = "user_id_user")
	private int user_idUser;
	
	@Column(name = "token")
	private String token;

	@OneToOne
	@JoinColumn(name = "user_id_user",insertable=false, updatable=false)
	private User user;

	@Column(name = "expiry_date")
	private Date expiryDate;

	public int getIdToken() {
		return idToken;
	}

	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + idToken;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + user_idUser;
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
		PasswordResetToken other = (PasswordResetToken) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (idToken != other.idToken)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PasswordResetToken [idToken=" + idToken + ", user_idUser="
				+ user_idUser + ", token=" + token + ", expiryDate="
				+ expiryDate + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}