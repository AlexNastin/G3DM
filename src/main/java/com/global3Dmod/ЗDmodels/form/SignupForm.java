package com.global3Dmod.ÇDmodels.form;

import com.global3Dmod.ÇDmodels.domain.Essence;

public class SignupForm implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8241003736927165196L;
	
	private int role_idRole;
	private String login;
	private String password;
	private String confirmPassword;
	private String nickName;
	
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

}
