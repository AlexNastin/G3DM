package com.global3Dmod.�Dmodels.form.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.service.IGuestService;

@Component
public class SignupValidator implements Validator {

	private static Logger LOGGER = Logger.getLogger(SignupValidator.class);

	@Autowired
	private IGuestService guestService;

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return SignupForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignupForm signupForm = (SignupForm) target;
		Matcher matcher = null;
		Pattern pattern = null;
		List<String> emails = null;
		List<String> nickNames = null;
		try {
			emails = guestService.getAllEmail();
			nickNames = guestService.getAllNickName();
		} catch (ServiceException e) {
			LOGGER.error("Problems with getting a name and/or nickname.", e);
		}

		// ��������� Role
		if ((signupForm.getRole_idRole() == 0)) {
			errors.rejectValue("role_idRole", "singup.valid.role.empty");
		}
		pattern = regExCollection.getRegEx(RegExName.REGEX_NICKNAME_USER);
		// ��������� NickName
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName",
				"singup.valid.nickName.empty");
		String userNickName = signupForm.getNickName();
		matcher = pattern.matcher(userNickName);
		// �� ������ ������. ���������� �� 3 �������� �� 16. ��������. ��� ������������.
		if (!matcher.matches()) {
			errors.rejectValue("nickName", "singup.valid.nickName.tooLong");
		}
		// ����������� �� ����� NickName � ��
		if (nickNames.contains(userNickName)) {
			errors.rejectValue("nickName", "singup.valid.nickName.exists");
		}

		// ��������� ������ � ���������� ��������� ������ � ��������������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"singup.valid.password.empty");
		if (!(signupForm.getPassword()).equals(signupForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword",
					"singup.valid.confirmPassword.passwordDontMatch");
		}
		// ��������� ������ (email) � �������� ���������� �� ����� ��� � ����
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
				"singup.valid.login.empty");
		if (!EmailValidator.getInstance().isValid(signupForm.getLogin())) {
			errors.rejectValue("login", "singup.valid.login.notValid");
		}
		if (emails.contains(signupForm.getLogin())) {
			errors.rejectValue("login", "singup.valid.login.exists");
		}

	}

}
