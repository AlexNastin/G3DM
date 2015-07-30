package com.global3Dmod.�Dmodels.form.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ValidationException;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.AddAdvertisementForm;
import com.global3Dmod.�Dmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.form.UpdateAdvertisementForm;
import com.global3Dmod.�Dmodels.form.UserPersonalDataForm;
import com.global3Dmod.�Dmodels.service.IGuestService;

@Component
public class UpdateAdvertisementValidator implements Validator {
	
	private final String NAME = "^[�-��-߸�a-zA-Z0-9]+$";
	private final String SURNAME = "^[�-��-߸�a-zA-Z0-9]+$";

	@Override
	public boolean supports(Class<?> arg0) {
		return UpdateAdvertisementForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UpdateAdvertisementForm updateAdvertisementForm = (UpdateAdvertisementForm) target;
		
//		Pattern patternName = Pattern.compile(NAME);
//		Pattern patternSurname = Pattern.compile(SURNAME);
//		//name validation
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
//				"addPost.valid.title.empty");
//		String name = personalDataForm.getName();
//		// �� ����� 16 ��������
//		if ((name.length()) > 16) {
//			errors.rejectValue("name", "singup.valid.nickName.tooLong");
//		}
//		//���������, ��������, �����
//		Matcher matcher = patternName.matcher(name);
//		if(!matcher.matches()) {
//			errors.rejectValue("name", "addPost.valid.file.format");
//		}
//		
//		//surname validation
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname",
//				"addPost.valid.title.empty");
//		String surname = personalDataForm.getSurname();
//		// �� ����� 16 ��������
//		if ((surname.length()) > 16) {
//			errors.rejectValue("surname", "singup.valid.nickName.tooLong");
//		}
//		//���������, ��������, �����
//		matcher = patternSurname.matcher(surname);
//		if(!matcher.matches()) {
//			errors.rejectValue("surname", "addPost.valid.file.format");
//		}
	}

}
