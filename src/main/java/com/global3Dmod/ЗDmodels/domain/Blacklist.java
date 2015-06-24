package com.global3Dmod.ÇDmodels.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "blacklists")
@NamedQuery(name="Blacklist.findAll", query="select b from Blacklist b")
public class Blacklist implements Essence {

	@Id
	@Column(name = "id_blacklist")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBlacklist;

	@Column(name = "user_id_user")
	private int user_idUser;

	@Column(name = "reason")
	private String reason;

	@Column(name = "date_time")
	private String dateTime;

	@Column(name = "is_banned")
	private boolean isBanned;

	public Blacklist() {
		super();
	}

	public int getIdBlacklist() {
		return idBlacklist;
	}

	public void setIdBlacklist(int idBlacklist) {
		this.idBlacklist = idBlacklist;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + idBlacklist;
		result = prime * result + (isBanned ? 1231 : 1237);
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
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
		Blacklist other = (Blacklist) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (idBlacklist != other.idBlacklist)
			return false;
		if (isBanned != other.isBanned)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Blacklist [idBlacklist=" + idBlacklist + ", user_idUser="
				+ user_idUser + ", reason=" + reason + ", dateTime=" + dateTime
				+ ", isBanned=" + isBanned + "]";
	}

}
