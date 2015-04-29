package com.global3Dmod.ÇDmodels.form;

import com.global3Dmod.ÇDmodels.domain.Essence;

public class PostForm implements Essence{

	private int category_idCategory;
	private int subcategory_idSubcategory;
	private int disProgram_idDisProgram;
	private String title;
	private String description;
	private String instruction;
	private String filePath;
	
	public int getCategory_idCategory() {
		return category_idCategory;
	}
	public void setCategory_idCategory(int category_idCategory) {
		this.category_idCategory = category_idCategory;
	}
	public int getSubcategory_idSubcategory() {
		return subcategory_idSubcategory;
	}
	public void setSubcategory_idSubcategory(int subcategory_idSubcategory) {
		this.subcategory_idSubcategory = subcategory_idSubcategory;
	}
	public int getDisProgram_idDisProgram() {
		return disProgram_idDisProgram;
	}
	public void setDisProgram_idDisProgram(int disProgram_idDisProgram) {
		this.disProgram_idDisProgram = disProgram_idDisProgram;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}	
	
}
