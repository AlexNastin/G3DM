package com.global3Dmod.ÇDmodel.form;

import com.global3Dmod.ÇDmodel.domain.Essence;

public class SignupForm implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9216190131891521986L;
	
	private int role_idRole;
	private String login;
	private String password;
	private String confirmPassword;
	private String nickName;
	
	public SignupForm() {
		super();
	}
	public int getRole_idRole() {
		return role_idRole;
	}
	public void setRole_idRole(int role_idRole) {
		this.role_idRole = role_idRole;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + role_idRole;
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
		SignupForm other = (SignupForm) obj;
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
		if (role_idRole != other.role_idRole)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SignupForm [role_idRole=" + role_idRole + ", login=" + login
				+ ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", nickName=" + nickName + "]";
	}
	

}
