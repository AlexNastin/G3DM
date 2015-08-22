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
import com.global3Dmod.�Dmodels.form.AddModeratorForm;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.form.regex.RegExCollection;
import com.global3Dmod.�Dmodels.form.regex.RegExName;
import com.global3Dmod.�Dmodels.service.IGuestService;

@Component
public class AddModeratorValidator implements Validator {

	private static Logger LOGGER = Logger
			.getLogger(AddModeratorValidator.class);

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
		AddModeratorForm addModeratorForm = (AddModeratorForm) target;
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

		// ��������� NickName
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName","valid.nickName.empty");
		String userNickName = addModeratorForm.getNickName();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_NICKNAME_USER);
		matcher = pattern.matcher(userNickName);
		// �� ������ ������. ���������� �� 3 �������� �� 16. ��������. ���
		// ������������.
		if (!matcher.matches()) {
			errors.rejectValue("nickName", "valid.nickName.pattern");
		}
		// ����������� �� ����� NickName � ��
		if (nickNames.contains(userNickName)) {
			errors.rejectValue("nickName", "valid.nickName.exists");
		}

		// ��������� Password � ConfirmPassword � �� ����������.
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"valid.password.empty");
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		matcher = pattern.matcher(addModeratorForm.getPassword());
		// �������� � ��������� ��������� �����, �����, �����������. �� 8
		// �������� �� 32
		if (!matcher.matches()) {
			errors.rejectValue("password", "valid.password.pattern");
		}
		if (!(addModeratorForm.getPassword()).equals(addModeratorForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "valid.confirmPassword.passwordDontMatch");
		}

		// ��������� Login (email)
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "valid.login.empty");
		// �� ��� ��� email
		if (!EmailValidator.getInstance().isValid(addModeratorForm.getLogin())) {
			errors.rejectValue("login", "valid.login.pattern");
		}
		// ����������� �� ����� Email � ��
		if (emails.contains(addModeratorForm.getLogin())) {
			errors.rejectValue("login", "valid.login.exists");
		}
		
		// ��������� Name
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameModerator", "valid.name.empty");
		String name = addModeratorForm.getNameModerator();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_FULL_NAME_USER);
		matcher = pattern.matcher(name);
		// ���������� �� 1 �������� �� 50. ��������. ��� ������������. (�����  - _)
		if (!matcher.matches()) {
			errors.rejectValue("nameModerator", "valid.name.pattern");
		}

		// ��������� Surname
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surnameModerator", "vaild.surname.empty");
		String surname = addModeratorForm.getSurnameModerator();
		// ���������� �� 1 �������� �� 50. ��������. ��� ������������. (�����  - _)
		matcher.reset(surname);
		if (!matcher.matches()) {
			errors.rejectValue("surnameModerator", "valid.surname.pattern");
		}
	}

}
