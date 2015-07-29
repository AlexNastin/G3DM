package com.global3Dmod.ЗDmodels.form.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.exception.ServiceException;
import com.global3Dmod.ЗDmodels.form.AddModeratorForm;
import com.global3Dmod.ЗDmodels.form.SignupForm;
import com.global3Dmod.ЗDmodels.service.IGuestService;

@Component
public class AddModeratorValidator implements Validator {

	private final String NAME = "^[а-яА-ЯёЁa-zA-Z0-9]+$";
	private final String SURNAME = "^[а-яА-ЯёЁa-zA-Z0-9]+$";

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
			// ОБРАБОТАТЬ!!!
		}

		// Валидация никнейма и проверка существует ли такой уже в базе
		// singup.valid.nickName.exists
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName",
				"singup.valid.nickName.empty");
		String userNickName = addModeratorForm.getNickName();
		// Не более 16 символов
		if ((userNickName.length()) > 16) {
			errors.rejectValue("nickName", "singup.valid.nickName.tooLong");
		}
		if (nickNames.contains(userNickName)) {
			errors.rejectValue("nickName", "singup.valid.nickName.exists");
		}

		// Валидация пароля и совпадение основного пароля и подтверждённого
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"singup.valid.password.empty");
		if (!(addModeratorForm.getPassword()).equals(addModeratorForm
				.getConfirmPassword())) {
			errors.rejectValue("confirmPassword",
					"singup.valid.confirmPassword.passwordDontMatch");
		}
		// Валидация логина (email) и проверка существует ли такой уже в базе
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
		// Не более 16 символов
		if ((name.length()) > 16) {
			errors.rejectValue("name", "singup.valid.nickName.tooLong");
		}
		// кириллица, латиница, цифры
		Matcher matcher = patternName.matcher(name);
		if (!matcher.matches()) {
			errors.rejectValue("name", "addPost.valid.file.format");
		}

		// surname validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname",
				"addPost.valid.title.empty");
		String surname = addModeratorForm.getSurname();
		// Не более 16 символов
		if ((surname.length()) > 16) {
			errors.rejectValue("surname", "singup.valid.nickName.tooLong");
		}
		// кириллица, латиница, цифры
		matcher = patternSurname.matcher(surname);
		if (!matcher.matches()) {
			errors.rejectValue("surname", "addPost.valid.file.format");
		}

	}

}
