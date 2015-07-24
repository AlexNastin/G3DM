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
import com.global3Dmod.�Dmodels.form.SignupForm;
import com.global3Dmod.�Dmodels.form.UserPersonalDataForm;
import com.global3Dmod.�Dmodels.service.IGuestService;

@Component
public class UserPersonalDataValidator implements Validator {

	@Autowired
	private IGuestService guestService;

	@Override
	public boolean supports(Class<?> arg0) {
		return UserPersonalDataForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserPersonalDataForm personalDataForm = (UserPersonalDataForm) target;

//		List<String> emails = null;
//		List<String> nickNames = null;
//		try {
//			emails = guestService.getAllEmail();
//			nickNames = guestService.getAllNickName();
//		} catch (ServiceException e) {
//			// ����������!!!
//		}
//
//		// ��������� ����
//		if ((signupForm.getRole_idRole() == 0)) {
//			errors.rejectValue("role_idRole", "singup.valid.role.empty");
//		}
//		// ��������� �������� � �������� ���������� �� ����� ��� � ����
//		// singup.valid.nickName.exists
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName",
//			"singup.valid.nickName.empty");
//		String userNickName = signupForm.getNickName();
//		// �� ����� 16 ��������
//		if ((userNickName.length()) > 16) {
//			errors.rejectValue("nickName", "singup.valid.nickName.tooLong");
//		}
//		if (nickNames.contains(userNickName)) {
//			errors.rejectValue("nickName", "singup.valid.nickName.exists");
//		}
//
//		// ��������� ������ � ���������� ��������� ������ � ��������������
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//				"singup.valid.password.empty");
//		if (!(signupForm.getPassword()).equals(signupForm.getConfirmPassword())) {
//			errors.rejectValue("confirmPassword",
//					"singup.valid.confirmPassword.passwordDontMatch");
//		}
//		// ��������� ������ (email) � �������� ���������� �� ����� ��� � ����
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
//				"singup.valid.login.empty");
//		if (!EmailValidator.getInstance().isValid(signupForm.getLogin())) {
//			errors.rejectValue("login", "singup.valid.login.notValid");
//		}
//		if (emails.contains(signupForm.getLogin())) {
//			errors.rejectValue("login", "singup.valid.login.exists");
//		}

	}

}
