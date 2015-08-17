package com.global3Dmod.�Dmodels.form;

import com.global3Dmod.�Dmodels.domain.Essence;

public class AddModeratorForm implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9030371630080102347L;

	private String login;
	private String password;
	private String confirmPassword;
	private String nickName;
	private String nameModerator;
	private String surnameModerator;

	public AddModeratorForm() {
		super();
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNameModerator() {
		return nameModerator;
	}

	public void setNameModerator(String nameModerator) {
		this.nameModerator = nameModerator;
	}

	public String getSurnameModerator() {
		return surnameModerator;
	}

	public void setSurnameModerator(String surnameModerator) {
		this.surnameModerator = surnameModerator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((nameModerator == null) ? 0 : nameModerator.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime
				* result
				+ ((surnameModerator == null) ? 0 : surnameModerator.hashCode());
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
		AddModeratorForm other = (AddModeratorForm) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nameModerator == null) {
			if (other.nameModerator != null)
				return false;
		} else if (!nameModerator.equals(other.nameModerator))
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
		if (surnameModerator == null) {
			if (other.surnameModerator != null)
				return false;
		} else if (!surnameModerator.equals(other.surnameModerator))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddModeratorForm [login=" + login + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", nickName="
				+ nickName + ", nameModerator=" + nameModerator
				+ ", surnameModerator=" + surnameModerator + "]";
	}

}
