package com.global3Dmod.ЗDmodels.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.CommentForm;

@Component
public class CommentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return CommentForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CommentForm commentForm = (CommentForm) target;

		// Валидация Comment
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "valid.comment.empty");

		// Количество от 2 символов до 300.
		if (commentForm.getComment().length() < 1 || commentForm.getComment().length() > 300) {
			errors.rejectValue("comment", "valid.comment.long");
		}
	}

}
