package com.global3Dmod.�Dmodel.form.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public final class RegExCollection {

	private Pattern PATTERN_NICKNAME_USER = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{3,16}$");
	private Pattern PATTERN_PASSWORD = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$");
	private Pattern PATTERN_UUID = Pattern.compile("^[0-9A-Fa-f]{8}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{12}$");
	private Pattern PATTERN_EMAIL = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");	
	private Pattern PATTERN_FULL_NAME_USER = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,50}$");
	private Pattern PATTERN_TITLE_POST = Pattern.compile("^[a-zA-Z0-9\\ \\'-\\_\\.]{1,50}$");
	private Pattern PATTERN_DESCRIPTION_POST = Pattern.compile("^[\\x00-\\x7F]{2,300}$");
	private Pattern PATTERN_INSTRUCTION_POST = Pattern.compile("^[\\x00-\\x7F]{2,1500}$");
	private Pattern PATTERN_MODEL_POST = Pattern.compile("([^.]+(\\.(?i)(rar|RAR|stl|STL|zip|ZIP))$)");
	private Pattern PATTERN_PHOTO_POST = Pattern.compile("([^.]+(\\.(?i)(jpg|JPEG|png|PNG|bmp|BMP))$)");
	private Pattern PATTERN_MESSAGE_POST = Pattern.compile("^[\\x00-\\x7F]{2,300}$");
	private Pattern PATTERN_FILE_EXT = Pattern.compile("((\\.(?i)(.{1,4}))$)");
	private Pattern PATTERN_DATE = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");

	private Map<String, Pattern> regEx = new HashMap<String, Pattern>();

	public RegExCollection() {
		regEx.put(RegExName.REGEX_NICKNAME_USER, PATTERN_NICKNAME_USER);
		regEx.put(RegExName.REGEX_PASSWORD, PATTERN_PASSWORD);
		regEx.put(RegExName.REGEX_UUID, PATTERN_UUID);
		regEx.put(RegExName.REGEX_EMAIL, PATTERN_EMAIL);
		regEx.put(RegExName.REGEX_FULL_NAME_USER, PATTERN_FULL_NAME_USER);
		regEx.put(RegExName.REGEX_TITLE_POST, PATTERN_TITLE_POST);
		regEx.put(RegExName.REGEX_DESCRIPTION_POST, PATTERN_DESCRIPTION_POST);
		regEx.put(RegExName.REGEX_INSTRUCTION_POST, PATTERN_INSTRUCTION_POST);
		regEx.put(RegExName.REGEX_MODEL_POST, PATTERN_MODEL_POST);
		regEx.put(RegExName.REGEX_PHOTO_POST, PATTERN_PHOTO_POST);
		regEx.put(RegExName.REGEX_MESSAGE_POST, PATTERN_MESSAGE_POST);
		regEx.put(RegExName.REGEX_FILE_EXT, PATTERN_FILE_EXT);
		regEx.put(RegExName.REGEX_DATE, PATTERN_DATE);
	}

	public Pattern getRegExPattern(String key) {
		return regEx.get(key);
	}

}
