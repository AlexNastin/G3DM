package com.global3Dmod.�Dmodels.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.form.UpdateForgotPasswordForm;

@Component
public class UpdateForgotPasswordValidator implements Validator {
	@Override
	public boolean supports(Class<?> arg0) {
		return UpdateForgotPasswordForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UpdateForgotPasswordForm updateForgotPasswordForm = (UpdateForgotPasswordForm) target;

		// ��������� ������ � ���������� ��������� ������ � ��������������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "singup.valid.password.empty");
		if (!(updateForgotPasswordForm.getPassword()).equals(updateForgotPasswordForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "singup.valid.confirmPassword.passwordDontMatch");

		}

	}
}
