package com.global3Dmod.ЗDmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.UpdateAdvertisementForm;

@Component
public class UpdateAdvertisementValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return UpdateAdvertisementForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UpdateAdvertisementForm updateAdvertisementForm = (UpdateAdvertisementForm) target;
		Pattern pattern = null;
		Matcher matcher = null;

		// Валидация Title
		// Количество от 2 символов до 16. Латиница. Нет спецсимволов. (кроме -
		// _ .)
		String title = updateAdvertisementForm.getTitle();
		if (title.length() != 0) {
			pattern = regExCollection
					.getRegExPattern(RegExName.REGEX_TITLE_POST);
			matcher = pattern.matcher(title);
			if (!matcher.matches()) {
				errors.rejectValue("title", "valid.title.pattern");
			}
		}
		// Валидация Description
		// Количество от 2 символов до 300. Латиница.
		String description = updateAdvertisementForm.getDescription();
		if (description.length() != 0) {
			pattern = regExCollection
					.getRegExPattern(RegExName.REGEX_DESCRIPTION_POST);
			matcher = pattern.matcher(description);
			if (!matcher.matches()) {
				errors.rejectValue("description", "valid.description.pattern");
			}
		}

		// Валидация AdvertisementPhoto
		if (!updateAdvertisementForm.getAdvertisementPhoto().isEmpty()) {
			String name = updateAdvertisementForm.getAdvertisementPhoto()
					.getOriginalFilename();
			// Расширение.
			pattern = regExCollection
					.getRegExPattern(RegExName.REGEX_PHOTO_POST);
			matcher = pattern.matcher(name);
			if (!matcher.matches()) {
				errors.rejectValue("advertisementPhoto",
						"valid.advertisementPhoto.pattern");
			}
		}

	}

}
