package com.global3Dmod.ЗDmodels.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.ЗDmodels.form.UpdatePostForm;
import com.global3Dmod.ЗDmodels.form.regex.RegExCollection;
import com.global3Dmod.ЗDmodels.form.regex.RegExName;

@Component
public class UpdatePostValidator implements Validator {

	@Autowired
	private RegExCollection regExCollection;

	@Override
	public boolean supports(Class<?> arg0) {
		return UpdatePostForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UpdatePostForm updatePostForm = (UpdatePostForm) target;

		Pattern pattern = null;
		Matcher matcher = null;

		// Валидация Title
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"valid.title.empty");
		// Количество от 2 символов до 50. Латиница. Нет спецсимволов. (кроме -
		// _ .)
		String title = updatePostForm.getTitle();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_TITLE_POST);
		matcher = pattern.matcher(title);
		if (!matcher.matches()) {
			errors.rejectValue("title", "valid.title.pattern");
		}

		// Валидация Description
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"valid.description.empty");
		// Количество от 2 символов до 300. Латиница.
		String description = updatePostForm.getDescription();
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_DESCRIPTION_POST);
		matcher = pattern.matcher(description);
		if (!matcher.matches()) {
			errors.rejectValue("description", "valid.description.pattern");
		}

		// Валидация Instruction
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instruction",
				"valid.instruction.empty");
		String instruction = updatePostForm.getInstruction();
		// Количество от 2 символов до 1500. Латиница.
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_INSTRUCTION_POST);
		matcher = pattern.matcher(instruction);
		if (!matcher.matches()) {
			errors.rejectValue("instruction", "valid.instruction.pattern");
		}
		
		// Валидация DisProgram
		// На пустое значение
		if (updatePostForm.getDisProgram_idDisProgram() == 0) {
			errors.rejectValue("disProgram_idDisProgram", "valid.disProgram.empty");
		}

		// Валидация Category
		// На пустое значение
		if (updatePostForm.getCategory_idCategory() == 0) {
			errors.rejectValue("category_idCategory", "valid.category.empty");
		}
		
		// Валидация Subcategory
		// На пустое значение
		if (updatePostForm.getSubcategory_idSubcategory() == 0) {
			errors.rejectValue("subcategory_idSubcategory",
					"valid.subcategory.empty");
		}
		// Валидация TechnologiesID
		// На пустое значение
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "technologiesId",
				"valid.technologies.empty");

		// Валидация ModelFile
		if (!updatePostForm.getModelUpdate().isEmpty()) {
			String name = updatePostForm.getModelUpdate().getOriginalFilename();
			// Расширение.
			pattern = regExCollection
					.getRegExPattern(RegExName.REGEX_MODEL_POST);
			matcher = pattern.matcher(name);
			if (!matcher.matches()) {
				errors.rejectValue("modelUpdate", "valid.modelFile.pattern");
			}
		}
		// Валидация FirstPhoto
		if (!updatePostForm.getFirstPhotoUpdate().isEmpty()) {
			String name = updatePostForm.getFirstPhotoUpdate().getOriginalFilename();
			// Расширение.
			pattern = regExCollection
					.getRegExPattern(RegExName.REGEX_PHOTO_POST);
			matcher = pattern.matcher(name);
			if (!matcher.matches()) {
				errors.rejectValue("firstPhotoUpdate", "valid.photoModelFile.pattern");
			}
		}
	}

}
