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
import com.global3Dmod.ЗDmodels.form.AddModeratorForm;
import com.global3Dmod.ЗDmodels.form.SignupForm;
import com.global3Dmod.ЗDmodels.form.regex.RegExCollection;
import com.global3Dmod.ЗDmodels.form.regex.RegExName;
import com.global3Dmod.ЗDmodels.service.IGuestService;

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

		// Валидация NickName
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName","valid.nickName.empty");
		String userNickName = addModeratorForm.getNickName();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_NICKNAME_USER);
		matcher = pattern.matcher(userNickName);
		// На пустую строку. Количество от 3 символов до 16. Латиница. Нет
		// спецсимволов.
		if (!matcher.matches()) {
			errors.rejectValue("nickName", "valid.nickName.pattern");
		}
		// Содержиться ли такой NickName в БД
		if (nickNames.contains(userNickName)) {
			errors.rejectValue("nickName", "valid.nickName.exists");
		}

		// Валидация Password и ConfirmPassword и их совпадение.
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"valid.password.empty");
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		matcher = pattern.matcher(addModeratorForm.getPassword());
		// Строчные и прописные латинские буквы, цифры, спецсимволы. От 8
		// символов до 32
		if (!matcher.matches()) {
			errors.rejectValue("password", "valid.password.pattern");
		}
		if (!(addModeratorForm.getPassword()).equals(addModeratorForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "valid.confirmPassword.passwordDontMatch");
		}

		// Валидация Login (email)
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "valid.login.empty");
		// На сам тип email
		if (!EmailValidator.getInstance().isValid(addModeratorForm.getLogin())) {
			errors.rejectValue("login", "valid.login.pattern");
		}
		// Содержиться ли такой Email в БД
		if (emails.contains(addModeratorForm.getLogin())) {
			errors.rejectValue("login", "valid.login.exists");
		}
		
		// Валидация Name
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameModerator", "valid.name.empty");
		String name = addModeratorForm.getNameModerator();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_FULL_NAME_USER);
		matcher = pattern.matcher(name);
		// Количество от 1 символов до 50. Латиница. Нет спецсимволов. (кроме  - _)
		if (!matcher.matches()) {
			errors.rejectValue("nameModerator", "valid.name.pattern");
		}

		// Валидация Surname
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surnameModerator", "vaild.surname.empty");
		String surname = addModeratorForm.getSurnameModerator();
		// Количество от 1 символов до 50. Латиница. Нет спецсимволов. (кроме  - _)
		matcher.reset(surname);
		if (!matcher.matches()) {
			errors.rejectValue("surnameModerator", "valid.surname.pattern");
		}
	}

}
