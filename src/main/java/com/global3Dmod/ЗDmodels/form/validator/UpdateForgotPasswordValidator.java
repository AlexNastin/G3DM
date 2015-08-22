package com.global3Dmod.ЗDmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.UpdateForgotPasswordForm;
import com.global3Dmod.ЗDmodels.form.regex.RegExCollection;
import com.global3Dmod.ЗDmodels.form.regex.RegExName;

@Component
public class UpdateForgotPasswordValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return UpdateForgotPasswordForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UpdateForgotPasswordForm updateForgotPasswordForm = (UpdateForgotPasswordForm) target;
		Matcher matcher = null;
		Pattern pattern = null;
		
		// Валидация Password и ConfirmPassword и их совпадение.
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password.empty");
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_PASSWORD);
		matcher = pattern.matcher(updateForgotPasswordForm.getPassword());
		// Строчные и прописные латинские буквы, цифры, спецсимволы. От 8 символов до 32
		if (!matcher.matches()) {
			errors.rejectValue("password", "valid.password.pattern");
		}
		if (!(updateForgotPasswordForm.getPassword())
				.equals(updateForgotPasswordForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword",
					"valid.confirmPassword.passwordDontMatch");
		}

	}
}
