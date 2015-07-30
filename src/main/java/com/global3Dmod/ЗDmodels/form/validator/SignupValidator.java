package com.global3Dmod.ЗDmodels.form.validator;

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

import com.global3Dmod.ЗDmodels.exception.ServiceException;
import com.global3Dmod.ЗDmodels.form.SignupForm;
import com.global3Dmod.ЗDmodels.service.IGuestService;

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

		// Валидация Role
		if ((signupForm.getRole_idRole() == 0)) {
			errors.rejectValue("role_idRole", "valid.role.empty");
		}
		pattern = regExCollection.getRegEx(RegExName.REGEX_NICKNAME_USER);
		// Валидация NickName
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "valid.nickName.empty");
		String userNickName = signupForm.getNickName();
		matcher = pattern.matcher(userNickName);
		// На пустую строку. Количество от 3 символов до 16. Латиница. Нет спецсимволов.
		if (!matcher.matches()) {
			errors.rejectValue("nickName", "valid.nickName.pattern");
		}
		// Содержиться ли такой NickName в БД
		if (nickNames.contains(userNickName)) {
			errors.rejectValue("nickName", "valid.nickName.exists");
		}

		// Валидация Password и ConfirmPassword и их совпадение.
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password.empty");
		pattern = regExCollection.getRegEx(RegExName.REGEX_PASSWORD);
		matcher = pattern.matcher(signupForm.getPassword());
		// Строчные и прописные латинские буквы, цифры, спецсимволы. От 8 символов до 32
		if (!matcher.matches()) {
			errors.rejectValue("password", "valid.password.pattern");
		}
		if (!(signupForm.getPassword()).equals(signupForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "valid.confirmPassword.passwordDontMatch");
		}
		
		// Валидация Login (email)
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "valid.login.empty");
		// На сам тип email
		if (!EmailValidator.getInstance().isValid(signupForm.getLogin())) {
			errors.rejectValue("login", "valid.login.pattern");
		}
		// Содержиться ли такой Email в БД
		if (emails.contains(signupForm.getLogin())) {
			errors.rejectValue("login", "valid.login.exists");
		}
	}
}
