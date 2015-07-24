package com.global3Dmod.ЗDmodels.form.validator;

import java.util.List;

import javax.validation.ValidationException;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.exception.ServiceException;
import com.global3Dmod.ЗDmodels.form.DesignerPersonalDataForm;
import com.global3Dmod.ЗDmodels.form.SignupForm;
import com.global3Dmod.ЗDmodels.form.UserPersonalDataForm;
import com.global3Dmod.ЗDmodels.service.IGuestService;

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
//			// ОБРАБОТАТЬ!!!
//		}
//
//		// Валидация роли
//		if ((signupForm.getRole_idRole() == 0)) {
//			errors.rejectValue("role_idRole", "singup.valid.role.empty");
//		}
//		// Валидация никнейма и проверка существует ли такой уже в базе
//		// singup.valid.nickName.exists
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName",
//			"singup.valid.nickName.empty");
//		String userNickName = signupForm.getNickName();
//		// Не более 16 символов
//		if ((userNickName.length()) > 16) {
//			errors.rejectValue("nickName", "singup.valid.nickName.tooLong");
//		}
//		if (nickNames.contains(userNickName)) {
//			errors.rejectValue("nickName", "singup.valid.nickName.exists");
//		}
//
//		// Валидация пароля и совпадение основного пароля и подтверждённого
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//				"singup.valid.password.empty");
//		if (!(signupForm.getPassword()).equals(signupForm.getConfirmPassword())) {
//			errors.rejectValue("confirmPassword",
//					"singup.valid.confirmPassword.passwordDontMatch");
//		}
//		// Валидация логина (email) и проверка существует ли такой уже в базе
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
