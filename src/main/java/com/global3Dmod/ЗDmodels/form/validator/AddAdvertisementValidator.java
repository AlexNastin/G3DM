package com.global3Dmod.�Dmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.form.AddAdvertisementForm;
import com.global3Dmod.�Dmodels.form.regex.RegExCollection;
import com.global3Dmod.�Dmodels.form.regex.RegExName;
import com.global3Dmod.�Dmodels.property.PropertyManagerG3DM;
import com.global3Dmod.�Dmodels.property.PropertyNameG3DM;

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

		// ��������� Title
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"valid.title.empty");
		// ���������� �� 2 �������� �� 16. ��������. ��� ������������. (����� -
		// _ .)
		String title = addAdvertisementForm.getTitle();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_TITLE_POST);
		matcher = pattern.matcher(title);
		if (!matcher.matches()) {
			errors.rejectValue("title", "valid.title.pattern");
		}

		// ��������� Description
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"valid.description.empty");
		// ���������� �� 2 �������� �� 300. ��������.
		String description = addAdvertisementForm.getDescription();
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_DESCRIPTION_POST);
		matcher = pattern.matcher(description);
		if (!matcher.matches()) {
			errors.rejectValue("description", "valid.description.pattern");
		}

		// ��������� Client
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "client",
				"valid.client.empty");
		String client = addAdvertisementForm.getClient();
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_NICKNAME_USER);
		matcher = pattern.matcher(client);
		// �� ������ ������. ���������� �� 3 �������� �� 16. ��������. ���
		// ������������.
		if (!matcher.matches()) {
			errors.rejectValue("client", "valid.client.pattern");
		}

		// ��������� ExpirationDate
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expirationDate",
				"valid.expirationDate.empty");
		// ��������� ExpirationDate
		String date = addAdvertisementForm.getExpirationDate();
		// �� ������ ���� XXXX-XX-XX, ��� X - ��� ����� �� 0 �� 9
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_DATE);
		matcher = pattern.matcher(date);
		// ���������� �� 1 �������� �� 50. ��������. ��� ������������.
		// (����� - _)
		if (!matcher.matches()) {
			errors.rejectValue("expirationDate", "valid.date.pattern");
		}
		// ��������� AdvertisementPhoto
		// �� ������ ��������
		if (!addAdvertisementForm.getAdvertisementPhoto().isEmpty()) {
			// �� ������ ����� (3MB)
			if (addAdvertisementForm.getAdvertisementPhoto().getSize() > Long
					.parseLong(propertyManagerG3DM
							.getValue(PropertyNameG3DM.MAX_SIZE_PHOTO))) {
				String name = addAdvertisementForm.getAdvertisementPhoto()
						.getOriginalFilename();
				// ����������.
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
