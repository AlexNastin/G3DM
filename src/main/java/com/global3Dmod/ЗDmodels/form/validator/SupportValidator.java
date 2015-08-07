package com.global3Dmod.ЗDmodels.form.validator;

import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.SupportForm;

@Component
public class SupportValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return SupportForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SupportForm supportForm = (SupportForm) target;

		// Валидация E-mail
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"valid.login.empty");
		// На сам тип email
		if (!EmailValidator.getInstance().isValid(supportForm.getEmail())) {
			errors.rejectValue("email", "valid.login.pattern");
		}

		// Валидация Text
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textSupport",
				"valid.comment.empty");

		// Количество от 1 символов до 500.
		if (supportForm.getTextSupport().length() < 1
				&& supportForm.getTextSupport().length() > 500) {
			errors.rejectValue("textSupport", "valid.comment.long");
		}
	}

}
