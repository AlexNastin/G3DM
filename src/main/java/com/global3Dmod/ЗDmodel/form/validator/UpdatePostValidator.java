package com.global3Dmod.�Dmodel.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.global3Dmod.�Dmodel.form.UpdatePostForm;
import com.global3Dmod.�Dmodel.form.regex.RegExCollection;
import com.global3Dmod.�Dmodel.form.regex.RegExName;
import com.global3Dmod.�Dmodel.property.PropertyManagerG3DM;
import com.global3Dmod.�Dmodel.property.PropertyNameG3DM;

@Component
public class UpdatePostValidator implements Validator {

	@Autowired
	private PropertyManagerG3DM propertyManagerG3DM;

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

		// ��������� Title
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"valid.title.empty");
		// ���������� �� 2 �������� �� 50. ��������. ��� ������������. (����� -
		// _ .)
		String title = updatePostForm.getTitle();
		pattern = regExCollection.getRegExPattern(RegExName.REGEX_TITLE_POST);
		matcher = pattern.matcher(title);
		if (!matcher.matches()) {
			errors.rejectValue("title", "valid.title.pattern");
		}

		// ��������� Description
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"valid.description.empty");
		// ���������� �� 2 �������� �� 300. ��������.
		String description = updatePostForm.getDescription();
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_DESCRIPTION_POST);
		matcher = pattern.matcher(description);
		if (!matcher.matches()) {
			errors.rejectValue("description", "valid.description.pattern");
		}

		// ��������� Instruction
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instruction",
				"valid.instruction.empty");
		String instruction = updatePostForm.getInstruction();
		// ���������� �� 2 �������� �� 1500. ��������.
		pattern = regExCollection
				.getRegExPattern(RegExName.REGEX_INSTRUCTION_POST);
		matcher = pattern.matcher(instruction);
		if (!matcher.matches()) {
			errors.rejectValue("instruction", "valid.instruction.pattern");
		}

		// ��������� DisProgram
		// �� ������ ��������
		if (updatePostForm.getDisProgram_idDisProgram() == 0) {
			errors.rejectValue("disProgram_idDisProgram",
					"valid.disProgram.empty");
		}

		// ��������� Category
		// �� ������ ��������
		if (updatePostForm.getCategory_idCategory() == 0) {
			errors.rejectValue("category_idCategory", "valid.category.empty");
		}

		// ��������� Subcategory
		// �� ������ ��������
		if (updatePostForm.getSubcategory_idSubcategory() == 0) {
			errors.rejectValue("subcategory_idSubcategory",
					"valid.subcategory.empty");
		}
		// ��������� TechnologiesID
		// �� ������ ��������
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "technologiesId",
				"valid.technologies.empty");

		// ��������� ModelFile
		if (!updatePostForm.getModelUpdate().isEmpty()) {
			// �� ������ ����� (100MB)
			if (!(updatePostForm.getModelUpdate().getSize() > Long
					.parseLong(propertyManagerG3DM
							.getValue(PropertyNameG3DM.MAX_SIZE_MODEL)))) {
				String name = updatePostForm.getModelUpdate()
						.getOriginalFilename();
				// ����������.
				pattern = regExCollection
						.getRegExPattern(RegExName.REGEX_MODEL_POST);
				matcher = pattern.matcher(name);
				if (!matcher.matches()) {
					errors.rejectValue("modelUpdate", "valid.modelFile.pattern");
				}
			} else {
				errors.rejectValue("modelUpdate", "valid.modelFile.maxsize");
			}
		}
		// ��������� FirstPhoto
		if (!updatePostForm.getFirstPhotoUpdate().isEmpty()) {
			// �� ������ ����� (3MB)
			if (!(updatePostForm.getFirstPhotoUpdate().getSize() > Long
					.parseLong(propertyManagerG3DM
							.getValue(PropertyNameG3DM.MAX_SIZE_PHOTO)))) {
				String name = updatePostForm.getFirstPhotoUpdate()
						.getOriginalFilename();
				// ����������.
				pattern = regExCollection
						.getRegExPattern(RegExName.REGEX_PHOTO_POST);
				matcher = pattern.matcher(name);
				if (!matcher.matches()) {
					errors.rejectValue("firstPhotoUpdate",
							"valid.photoModelFile.pattern");
				}
			} else {
				errors.rejectValue("firstPhotoUpdate",
						"valid.photoModelFile.maxsize");
			}
		}
	}

}
