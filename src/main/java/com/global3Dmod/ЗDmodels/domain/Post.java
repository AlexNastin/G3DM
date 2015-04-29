package com.global3Dmod.ÇDmodels.domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "POSTS")
@NamedQuery(name="Post.findAll", query="select p from Post p")
public class Post implements Essence {

	@Id
	@Column(name = "idPost")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPost;

	@Column(name = "user_idUser")
	private int user_idUser;

	@Column(name = "category_idCategory")
	private int category_idCategory;

	@Column(name = "subcategory_idSubcategory")
	private int subcategory_idSubcategory;
	
	@Column(name = "numberPost")
	private String numberPost;
	
	@Column(name = "disProgram_idDisProgram")
	private int disProgram_idDisProgram;

	@Column(name = "dateReg")
	private String dateReg;
	
	@Column(name = "dateUpdate")
	private String dateUpdate;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "instruction")
	private String instruction;

	@Column(name = "isDisplay")
	private boolean isDisplay;

	@Column(name = "countDownload")
	private int countDownload;
	
	public Post() {
		super();
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
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

	public String getDateReg() {
		return dateReg;
	}

	public void setDateReg(String dateReg) {
		this.dateReg = dateReg;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
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

	public String getNumberPost() {
		return numberPost;
	}

	public void setNumberPost(String numberPost) {
		this.numberPost = numberPost;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public boolean isDisplay() {
		return isDisplay;
	}

	public void setDisplay(boolean isDisplay) {
		this.isDisplay = isDisplay;
	}

	public int getCountDownload() {
		return countDownload;
	}

	public void setCountDownload(int countDownload) {
		this.countDownload = countDownload;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_idCategory;
		result = prime * result + countDownload;
		result = prime * result + ((dateReg == null) ? 0 : dateReg.hashCode());
		result = prime * result
				+ ((dateUpdate == null) ? 0 : dateUpdate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + disProgram_idDisProgram;
		result = prime * result + idPost;
		result = prime * result
				+ ((instruction == null) ? 0 : instruction.hashCode());
		result = prime * result + (isDisplay ? 1231 : 1237);
		result = prime * result
				+ ((numberPost == null) ? 0 : numberPost.hashCode());
		result = prime * result + subcategory_idSubcategory;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + user_idUser;
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
		Post other = (Post) obj;
		if (category_idCategory != other.category_idCategory)
			return false;
		if (countDownload != other.countDownload)
			return false;
		if (dateReg == null) {
			if (other.dateReg != null)
				return false;
		} else if (!dateReg.equals(other.dateReg))
			return false;
		if (dateUpdate == null) {
			if (other.dateUpdate != null)
				return false;
		} else if (!dateUpdate.equals(other.dateUpdate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (disProgram_idDisProgram != other.disProgram_idDisProgram)
			return false;
		if (idPost != other.idPost)
			return false;
		if (instruction == null) {
			if (other.instruction != null)
				return false;
		} else if (!instruction.equals(other.instruction))
			return false;
		if (isDisplay != other.isDisplay)
			return false;
		if (numberPost == null) {
			if (other.numberPost != null)
				return false;
		} else if (!numberPost.equals(other.numberPost))
			return false;
		if (subcategory_idSubcategory != other.subcategory_idSubcategory)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", user_idUser=" + user_idUser
				+ ", category_idCategory=" + category_idCategory
				+ ", subcategory_idSubcategory=" + subcategory_idSubcategory
				+ ", numberPost=" + numberPost + ", disProgram_idDisProgram="
				+ disProgram_idDisProgram + ", dateReg=" + dateReg
				+ ", dateUpdate=" + dateUpdate + ", title=" + title
				+ ", description=" + description + ", instruction="
				+ instruction + ", isDisplay=" + isDisplay + ", countDownload="
				+ countDownload + "]";
	}



	

}
