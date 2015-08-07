package com.global3Dmod.�Dmodels.form.validator;

import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.form.SupportForm;

@Component
public class SupportValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return SupportForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SupportForm supportForm = (SupportForm) target;

		// ��������� E-mail
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"valid.login.empty");
		// �� ��� ��� email
		if (!EmailValidator.getInstance().isValid(supportForm.getEmail())) {
			errors.rejectValue("email", "valid.login.pattern");
		}

		// ��������� Text
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textSupport",
				"valid.comment.empty");

		// ���������� �� 1 �������� �� 500.
		if (supportForm.getTextSupport().length() < 1
				&& supportForm.getTextSupport().length() > 500) {
			errors.rejectValue("textSupport", "valid.comment.long");
		}
	}

}
