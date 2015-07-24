package com.global3Dmod.�Dmodels.form.validator;

import java.util.List;

import javax.validation.ValidationException;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodels.exception.ServiceException;
import com.global3Dmod.�Dmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.�Dmodels.form.DesignerPersonalSecurityForm;
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.service.IGuestService;

@Component
public class DesignerPersonalSecurityValidator implements Validator {

	@Autowired
	private IGuestService guestService;

	@Override
	public boolean supports(Class<?> arg0) {
		return DesignerPersonalSecurityForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		DesignerPersonalSecurityForm personalSecurityForm = (DesignerPersonalSecurityForm) target;

		// ��������� ������ � ���������� ��������� ������ � ��������������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"singup.valid.password.empty");
		if (!(personalSecurityForm.getPassword()).equals(personalSecurityForm.getConfirmPassword())) {
			errors.rejectValue("confirmPassword",
					"singup.valid.confirmPassword.passwordDontMatch"); //�������� ����������� �����
		}

	}

}
