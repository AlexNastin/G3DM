package com.global3Dmod.�Dmodels.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.global3Dmod.�Dmodels.form.UserPersonalSecurityForm;

@Component
public class UserPersonalSecurityValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return UserPersonalSecurityForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserPersonalSecurityForm personalSecurityForm = (UserPersonalSecurityForm) target;

		// ��������� ������ � ���������� ��������� ������ � ��������������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "singup.valid.password.empty");
		if (!(personalSecurityForm.getPassword()).equals(personalSecurityForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "singup.valid.confirmPassword.passwordDontMatch");
			
		}

	}

}
