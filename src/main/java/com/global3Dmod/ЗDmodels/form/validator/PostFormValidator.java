package com.global3Dmod.ЗDmodels.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.PostForm;

@Component
public class PostFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return PostFormValidator.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PostForm postForm = (PostForm) target;
		
		final String zip = "application/x-zip-compressed";
		final String jpg = "image/jpeg";
		final String stl = "application/vnd.ms-pki.stl";
		
		//title validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"addPost.valid.title.empty");
		String title = postForm.getTitle();
		// Не более 20 символов
		if ((title.length()) > 20) {
			errors.rejectValue("title", "addPost.valid.title.tooLong");
		}
		
		//description validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"addPost.valid.description.empty");
		String description = postForm.getDescription();
		// Не более 200 символов
		if ((description.length()) > 200) {
			errors.rejectValue("description", "addPost.valid.description.tooLong");
		}
		
		//instruction validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instruction",
				"addPost.valid.instruction.empty");
		String instruction = postForm.getInstruction();
		// Не более 200 символов
		if ((instruction.length()) > 200) {
			errors.rejectValue("instruction", "addPost.valid.instruction.tooLong");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "printersId",
				"addPost.valid.printersId.empty");
		
		//model file validation
		if (!postForm.getModel().isEmpty()) {
			String contentType = postForm.getModel().getContentType();
			if(!contentType.equalsIgnoreCase(stl) && !contentType.equalsIgnoreCase(zip)) {
				errors.rejectValue("model", "addPost.valid.file.format");
			}
		}
		else {
			errors.rejectValue("model", "addPost.valid.modelFile.empty");
		}
		
		//first photo file validation
		if (!postForm.getFirstPhoto().isEmpty()) {
			String contentType = postForm.getFirstPhoto().getContentType();
			if(!contentType.equalsIgnoreCase(jpg)) {
				errors.rejectValue("firstPhoto", "addPost.valid.file.format");
			}
		}
		else {
			errors.rejectValue("firstPhoto", "addPost.valid.photoModelFile.empty");
		}
		
		//second photo file validation
		if (!postForm.getSecondPhoto().isEmpty()) {
			String contentType = postForm.getSecondPhoto().getContentType();
			if(!contentType.equalsIgnoreCase(jpg)) {
				errors.rejectValue("secondPhoto", "addPost.valid.file.format");
			}
		}
		else {
			errors.rejectValue("secondPhoto", "addPost.valid.photoModelFile.empty");
		}
		
		//third photo file validation
		if (!postForm.getThirdPhoto().isEmpty()) {
			String contentType = postForm.getThirdPhoto().getContentType();
			if(!contentType.equalsIgnoreCase(jpg)) {
				errors.rejectValue("thirdPhoto", "addPost.valid.file.format");
			}
		}
		else {
			errors.rejectValue("thirdPhoto", "addPost.valid.photoModelFile.empty");
		}
		

		
		
	}

}
