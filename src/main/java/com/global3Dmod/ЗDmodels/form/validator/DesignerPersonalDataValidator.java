package com.global3Dmod.�Dmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.form.DesignerPersonalDataForm;

@Component
public class DesignerPersonalDataValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return DesignerPersonalDataForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DesignerPersonalDataForm personalDataForm = (DesignerPersonalDataForm) target;
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
			String nameAvatar = personalDataForm.getAvatar()
					.getOriginalFilename();
			// ����������.
			pattern = regExCollection
					.getRegExPattern(RegExName.REGEX_PHOTO_POST);
			matcher = pattern.matcher(nameAvatar);
			if (!matcher.matches()) {
				errors.rejectValue("avatar", "valid.avatar.pattern");
			}
		}
	}

}