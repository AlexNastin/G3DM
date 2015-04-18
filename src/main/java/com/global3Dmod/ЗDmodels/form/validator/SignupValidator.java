package com.global3Dmod.�Dmodels.form.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.form.SignupForm;

@Component
public class SignupValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return SignupForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignupForm signupForm = (SignupForm) target;
		//��������� ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "singup.valid.nickName.empty");
		String username = signupForm.getNickName();
		//�� ����� 16 ��������
		if ((username.length()) > 16) {
			errors.rejectValue("nickName", "singup.valid.nickName.tooLong");
		}
		//��������� ������ � ���������� ��������� ������ � ��������������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "singup.valid.password.empty");
		if (!(signupForm.getPassword()).equals(signupForm
				.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "singup.valid.confirmPassword.passwordDontMatch");
		}
		//��������� ������ (email)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "singup.valid.login.empty");
		if( !EmailValidator.getInstance().isValid( signupForm.getLogin() ) ){
			errors.rejectValue("login", "singup.valid.login.notValid");
		}
		
	}

}
