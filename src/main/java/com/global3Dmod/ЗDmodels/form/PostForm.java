package com.global3Dmod.ÇDmodels.form;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import com.global3Dmod.ÇDmodels.domain.Essence;

public class PostForm implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8708716890029067738L;
	
	private String title;
	private String description;
	private String instruction;
	private int category_idCategory;
	private int subcategory_idSubcategory;
	private int disProgram_idDisProgram;
	
	// File
	private MultipartFile model;
	private MultipartFile firstPhoto;

	// Technologies
	private String[] technologiesId;
	
	public PostForm() {
		super();
	}

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

	public MultipartFile getModel() {
		return model;
	}

	public void setModel(MultipartFile model) {
		this.model = model;
	}

	public MultipartFile getFirstPhoto() {
		return firstPhoto;
	}

	public void setFirstPhoto(MultipartFile firstPhoto) {
		this.firstPhoto = firstPhoto;
	}

	public String[] getTechnologiesId() {
		return technologiesId;
	}

	public void setTechnologiesId(String[] technologiesId) {
		this.technologiesId = technologiesId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_idCategory;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + disProgram_idDisProgram;
		result = prime * result
				+ ((firstPhoto == null) ? 0 : firstPhoto.hashCode());
		result = prime * result
				+ ((instruction == null) ? 0 : instruction.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + subcategory_idSubcategory;
		result = prime * result + Arrays.hashCode(technologiesId);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostForm other = (PostForm) obj;
		if (category_idCategory != other.category_idCategory)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (disProgram_idDisProgram != other.disProgram_idDisProgram)
			return false;
		if (firstPhoto == null) {
			if (other.firstPhoto != null)
				return false;
		} else if (!firstPhoto.equals(other.firstPhoto))
			return false;
		if (instruction == null) {
			if (other.instruction != null)
				return false;
		} else if (!instruction.equals(other.instruction))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (subcategory_idSubcategory != other.subcategory_idSubcategory)
			return false;
		if (!Arrays.equals(technologiesId, other.technologiesId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostForm [category_idCategory=" + category_idCategory
				+ ", subcategory_idSubcategory=" + subcategory_idSubcategory
				+ ", disProgram_idDisProgram=" + disProgram_idDisProgram
				+ ", title=" + title + ", description=" + description
				+ ", instruction=" + instruction + ", model=" + model
				+ ", firstPhoto=" + firstPhoto + ", technologiesId="
				+ Arrays.toString(technologiesId) + "]";
	}

}
