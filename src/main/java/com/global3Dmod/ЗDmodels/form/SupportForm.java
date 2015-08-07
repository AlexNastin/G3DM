package com.global3Dmod.ÇDmodels.form;

import com.global3Dmod.ÇDmodels.domain.Essence;

public class SupportForm implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 313435865134055072L;

	private String email;

	private String textSupport;

	public SupportForm() {
		super();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getTextSupport() {
		return textSupport;
	}



	public void setTextSupport(String textSupport) {
		this.textSupport = textSupport;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((textSupport == null) ? 0 : textSupport.hashCode());
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
		SupportForm other = (SupportForm) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (textSupport == null) {
			if (other.textSupport != null)
				return false;
		} else if (!textSupport.equals(other.textSupport))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SupportForm [email=" + email + ", textSupport=" + textSupport
				+ "]";
	}

}
