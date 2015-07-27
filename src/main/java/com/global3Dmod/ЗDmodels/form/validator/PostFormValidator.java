package com.global3Dmod.ЗDmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.PostForm;

@Component
public class PostFormValidator implements Validator{
	
	private final String MODEL = ".+\\.(rar|RAR|stl|STL|zip|ZIP)";
	private final String PHOTO = ".+\\.(jpeg|JPEG|jpg|JPG)";

	@Override
	public boolean supports(Class<?> arg0) {
		return PostFormValidator.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PostForm postForm = (PostForm) target;
		
		 Pattern model = Pattern.compile(MODEL);
		 Pattern photo = Pattern.compile(PHOTO);
		
		
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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "technologiesId",
				"addPost.valid.technologiesId.empty");
		
		//model file validation
		if (!postForm.getModel().isEmpty()) {
			String name = postForm.getModel().getOriginalFilename();
			Matcher matcher = model.matcher(name);
			if(!matcher.matches()) {
				errors.rejectValue("model", "addPost.valid.file.format");
			}
		}
		else {
			errors.rejectValue("model", "addPost.valid.modelFile.empty");
		}
		
		//first photo file validation
		if (!postForm.getFirstPhoto().isEmpty()) {
			String name = postForm.getFirstPhoto().getOriginalFilename();
			Matcher matcher = photo.matcher(name);
			if(!matcher.matches()) {
				errors.rejectValue("firstPhoto", "addPost.valid.file.format");
			}
		}
		else {
			errors.rejectValue("firstPhoto", "addPost.valid.photoModelFile.empty");
		}
	}

}
