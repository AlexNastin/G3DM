package com.global3Dmod.ÇDmodels.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ÇDmodels.form.PostForm;

@Component
public class PostFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return PostFormValidator.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		PostForm postForm = (PostForm) target;
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
//				"title empty");
//			String title = postForm.getTitle();
//			// Íå áîëåå 16 ñèìâîëîâ
//			if ((title.length()) > 15) {
//				errors.rejectValue("title", "title tooLong");
//			}
//			if (title.contains(title)) {
//				errors.rejectValue("title", "title exists");
//			}
		
	}

}
