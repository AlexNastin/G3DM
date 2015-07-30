package com.global3Dmod.�Dmodels.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;





import com.global3Dmod.�Dmodels.form.CommentForm;


@Component
public class CommentValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return CommentForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CommentForm commentForm = (CommentForm) target;
		
		// ��������� Comment
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "valid.comment.empty");
		
		//���������� �� 1 �������� �� 300. 
		if (commentForm.getComment().length() < 1 && commentForm.getComment().length() > 300) {
			errors.rejectValue("comment", "valid.comment.long");
		}
	}

}
