package com.global3Dmod.�Dmodels.form.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.AddModeratorForm;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.service.IGuestService;

@Component
public class AddModeratorValidator implements Validator {

	private final String NAME = "^[�-��-߸�a-zA-Z0-9]+$";
	private final String SURNAME = "^[�-��-߸�a-zA-Z0-9]+$";

	@Autowired
	private IGuestService guestService;

	@Override
	public boolean supports(Class<?> arg0) {
		return SignupForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Pattern patternName = Pattern.compile(NAME);
		Pattern patternSurname = Pattern.compile(SURNAME);
		AddModeratorForm addModeratorForm = (AddModeratorForm) target;

		List<String> emails = null;
		List<String> nickNames = null;
		try {
			emails = guestService.getAllEmail();
			nickNames = guestService.getAllNickName();
		} catch (ServiceException e) {
			// ����������!!!
		}

		// ��������� �������� � �������� ���������� �� ����� ��� � ����
		// singup.valid.nickName.exists
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName",
				"singup.valid.nickName.empty");
		String userNickName = addModeratorForm.getNickName();
		// �� ����� 16 ��������
		if ((userNickName.length()) > 16) {
			errors.rejectValue("nickName", "singup.valid.nickName.tooLong");
		}
		if (nickNames.contains(userNickName)) {
			errors.rejectValue("nickName", "singup.valid.nickName.exists");
		}

		// ��������� ������ � ���������� ��������� ������ � ��������������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"singup.valid.password.empty");
		if (!(addModeratorForm.getPassword()).equals(addModeratorForm
				.getConfirmPassword())) {
			errors.rejectValue("confirmPassword",
					"singup.valid.confirmPassword.passwordDontMatch");
		}
		// ��������� ������ (email) � �������� ���������� �� ����� ��� � ����
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
				"singup.valid.login.empty");
		if (!EmailValidator.getInstance().isValid(addModeratorForm.getLogin())) {
			errors.rejectValue("login", "singup.valid.login.notValid");
		}
		if (emails.contains(addModeratorForm.getLogin())) {
			errors.rejectValue("login", "singup.valid.login.exists");
		}
		// name validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"addPost.valid.title.empty");
		String name = addModeratorForm.getName();
		// �� ����� 16 ��������
		if ((name.length()) > 16) {
			errors.rejectValue("name", "singup.valid.nickName.tooLong");
		}
		// ���������, ��������, �����
		Matcher matcher = patternName.matcher(name);
		if (!matcher.matches()) {
			errors.rejectValue("name", "addPost.valid.file.format");
		}

		// surname validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname",
				"addPost.valid.title.empty");
		String surname = addModeratorForm.getSurname();
		// �� ����� 16 ��������
		if ((surname.length()) > 16) {
			errors.rejectValue("surname", "singup.valid.nickName.tooLong");
		}
		// ���������, ��������, �����
		matcher = patternSurname.matcher(surname);
		if (!matcher.matches()) {
			errors.rejectValue("surname", "addPost.valid.file.format");
		}

	}

}
