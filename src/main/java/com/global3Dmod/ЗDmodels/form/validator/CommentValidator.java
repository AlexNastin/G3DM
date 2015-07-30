package com.global3Dmod.ЗDmodels.form.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;




import com.global3Dmod.ЗDmodels.form.CommentForm;


@Component
public class CommentValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return CommentForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CommentForm commentForm = (CommentForm) target;
		Matcher matcher = null;
		Pattern pattern = null;
		// Валидация Comment
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "valid.nickName.empty");

	}

}
