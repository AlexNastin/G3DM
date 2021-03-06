package com.global3Dmod.�Dmodel.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodel.form.UserPersonalSecurityForm;
import com.global3Dmod.�Dmodel.form.regex.RegExCollection;
import com.global3Dmod.�Dmodel.form.regex.RegExName;

@Component
public class UserPersonalSecurityValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return UserPersonalSecurityForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserPersonalSecurityForm personalSecurityForm = (UserPersonalSecurityForm) target;
		Matcher matcher = null;
		Pattern pattern = null;

		// ��������� Password � ConfirmPassword � �� ����������.
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"valid.password.empty");
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		matcher = pattern.matcher(personalSecurityForm.getPassword());
		// �������� � ��������� ��������� �����, �����, �����������. �� 8
		// �������� �� 32
		if (!matcher.matches()) {
			errors.rejectValue("password", "valid.password.pattern");
		}
		if (!(personalSecurityForm.getPassword()).equals(personalSecurityForm
				.getConfirmPassword())) {
			errors.rejectValue("confirmPassword",
					"valid.confirmPassword.passwordDontMatch");
		}

	}

}
