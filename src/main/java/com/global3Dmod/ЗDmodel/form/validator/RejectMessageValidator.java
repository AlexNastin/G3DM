package com.global3Dmod.�Dmodel.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodel.form.RejectMessageForm;
import com.global3Dmod.�Dmodel.form.regex.RegExCollection;
import com.global3Dmod.�Dmodel.form.regex.RegExName;

@Component
public class RejectMessageValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return RejectMessageForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RejectMessageForm rejectMessageForm = (RejectMessageForm) target;
		Pattern pattern = null;
		Matcher matcher = null;
		
		// ��������� Message(text)
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "valid.message.empty");
		// ���������� �� 2 �������� �� 300. ��������.
		String text = rejectMessageForm.getText();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_MESSAGE_POST);
		matcher = pattern.matcher(text);
		if (!matcher.matches()) {
			errors.rejectValue("text", "valid.message.pattern");
		}

	}

}
