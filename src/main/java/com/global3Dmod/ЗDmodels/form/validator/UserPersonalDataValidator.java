package com.global3Dmod.�Dmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.form.UserPersonalDataForm;
import com.global3Dmod.�Dmodels.form.regex.RegExCollection;
import com.global3Dmod.�Dmodels.form.regex.RegExName;
import com.global3Dmod.�Dmodels.property.PropertyManagerG3DM;
import com.global3Dmod.�Dmodels.property.PropertyNameG3DM;

@Component
public class UserPersonalDataValidator implements Validator {

	@Autowired
	private PropertyManagerG3DM propertyManagerG3DM;

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return UserPersonalDataForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserPersonalDataForm personalDataForm = (UserPersonalDataForm) target;

		Matcher matcher = null;
		Pattern pattern = null;

		// ��������� Name
		String name = personalDataForm.getName();
		if (name.length() != 0) {
			pattern = regExCollection
					.getRegExPattern(RegExName.REGEX_FULL_NAME_USER);
			matcher = pattern.matcher(name);
			// ���������� �� 1 �������� �� 50. ��������. ��� ������������.
			// (����� - _)
			if (!matcher.matches()) {
				errors.rejectValue("name", "valid.name.pattern.notempty");
			}
		}

		// ��������� Surname
		String surname = personalDataForm.getSurname();
		// ���������� �� 1 �������� �� 50. ��������. ��� ������������. (����� -
		// _)
		if (surname.length() != 0) {
			matcher.reset(surname);
			if (!matcher.matches()) {
				errors.rejectValue("surname", "valid.surname.pattern.notempty");
			}
		}

		// ��������� Date
		String date = personalDataForm.getDateBirth();
		// �� ������ ���� XXXX-XX-XX, ��� X - ��� ����� �� 0 �� 9
		if (date.length() != 0) {
			pattern = regExCollection.getRegExPattern(RegExName.REGEX_DATE);
			matcher = pattern.matcher(date);
			// ���������� �� 1 �������� �� 50. ��������. ��� ������������.
			// (����� - _)
			if (!matcher.matches()) {
				errors.rejectValue("dateBirth", "valid.date.pattern");
			}
		}

		// ��������� Avatar
		if (!personalDataForm.getAvatar().isEmpty()) {
			// �� ������ ����� (3MB)
			if (personalDataForm.getAvatar().getSize() > Long
					.parseLong(propertyManagerG3DM
							.getValue(PropertyNameG3DM.MAX_SIZE_AVATAR))) {
				String nameAvatar = personalDataForm.getAvatar()
						.getOriginalFilename();
				// ����������.
				pattern = regExCollection
						.getRegExPattern(RegExName.REGEX_PHOTO_POST);
				matcher = pattern.matcher(nameAvatar);
				if (!matcher.matches()) {
					errors.rejectValue("avatar", "valid.avatar.pattern");
				}
			} else {
				errors.rejectValue("avatar", "valid.avatar.maxsize");
			}

		}

	}

}
