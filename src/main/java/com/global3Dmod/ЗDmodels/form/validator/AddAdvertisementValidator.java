package com.global3Dmod.ЗDmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.AddAdvertisementForm;
import com.global3Dmod.ЗDmodels.form.regex.RegExCollection;
import com.global3Dmod.ЗDmodels.form.regex.RegExName;
import com.global3Dmod.ЗDmodels.property.PropertyManagerG3DM;
import com.global3Dmod.ЗDmodels.property.PropertyNameG3DM;

@Component
public class AddAdvertisementValidator implements Validator {

	@Autowired
	private PropertyManagerG3DM propertyManagerG3DM;

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return AddAdvertisementForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddAdvertisementForm addAdvertisementForm = (AddAdvertisementForm) target;
		Pattern pattern = null;
		Matcher matcher = null;

		// Валидация Title
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"valid.title.empty");
		// Количество от 2 символов до 16. Латиница. Нет спецсимволов. (кроме -
		// _ .)
		String title = addAdvertisementForm.getTitle();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_TITLE_POST);
		matcher = pattern.matcher(title);
		if (!matcher.matches()) {
			errors.rejectValue("title", "valid.title.pattern");
		}

		// Валидация Description
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"valid.description.empty");
		// Количество от 2 символов до 300. Латиница.
		String description = addAdvertisementForm.getDescription();
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_DESCRIPTION_POST);
		matcher = pattern.matcher(description);
		if (!matcher.matches()) {
			errors.rejectValue("description", "valid.description.pattern");
		}

		// Валидация Client
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "client",
				"valid.client.empty");
		String client = addAdvertisementForm.getClient();
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_NICKNAME_USER);
		matcher = pattern.matcher(client);
		// На пустую строку. Количество от 3 символов до 16. Латиница. Нет
		// спецсимволов.
		if (!matcher.matches()) {
			errors.rejectValue("client", "valid.client.pattern");
		}

		// Валидация ExpirationDate
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expirationDate",
				"valid.expirationDate.empty");
		// Валидация ExpirationDate
		String date = addAdvertisementForm.getExpirationDate();
		// На строку типа XXXX-XX-XX, где X - это число от 0 до 9
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_DATE);
		matcher = pattern.matcher(date);
		// Количество от 1 символов до 50. Латиница. Нет спецсимволов.
		// (кроме - _)
		if (!matcher.matches()) {
			errors.rejectValue("expirationDate", "valid.date.pattern");
		}
		// Валидация AdvertisementPhoto
		// На пустое значение
		if (!addAdvertisementForm.getAdvertisementPhoto().isEmpty()) {
			// На размер файла (3MB)
			if (addAdvertisementForm.getAdvertisementPhoto().getSize() > Long
					.parseLong(propertyManagerG3DM
							.getValue(PropertyNameG3DM.MAX_SIZE_PHOTO))) {
				String name = addAdvertisementForm.getAdvertisementPhoto()
						.getOriginalFilename();
				// Расширение.
				pattern = regExCollection
						.getRegExPattern(RegExName.REGEX_PHOTO_POST);
				matcher = pattern.matcher(name);
				if (!matcher.matches()) {
					errors.rejectValue("advertisementPhoto",
							"valid.advertisementPhoto.pattern");
				}
			} else {
				errors.rejectValue("advertisementPhoto",
						"valid.advertisementPhoto.maxsize");
			}
		} else {
			errors.rejectValue("advertisementPhoto",
					"valid.advertisementPhoto.empty");
		}
	}

}
