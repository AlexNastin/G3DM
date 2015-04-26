package com.global3Dmod.�Dmodels.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.form.PostForm;
import com.global3Dmod.�Dmodels.form.SignupForm;

public class PostFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return SignupForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		PostForm postForm = (PostForm) target;
		
	}

}
