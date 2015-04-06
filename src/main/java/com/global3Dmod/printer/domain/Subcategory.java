package com.global3Dmod.printer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Subcategories")
@NamedQuery(name="Subcategory.findAll", query="select s from Subcategory s")
public class Subcategory implements Essence {

	@Id
	@Column(name = "idSubcategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubcategory;

	@Column(name = "category_idÑategory")
	private int category_idÑategory;

	@Column(name = "title")
	private String title;

	public Subcategory() {
		super();
	}

	public int getIdSubcategory() {
		return idSubcategory;
	}

	public void setIdSubcategory(int idSubcategory) {
		this.idSubcategory = idSubcategory;
	}

	public int getCategory_idÑategory() {
		return category_idÑategory;
	}

	public void setCategory_idÑategory(int category_idÑategory) {
		this.category_idÑategory = category_idÑategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_idÑategory;
		result = prime * result + idSubcategory;
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
		Subcategory other = (Subcategory) obj;
		if (category_idÑategory != other.category_idÑategory)
			return false;
		if (idSubcategory != other.idSubcategory)
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
		return "Subcategory [idSubcategory=" + idSubcategory
				+ ", category_idÑategory=" + category_idÑategory + ", title="
				+ title + "]";
	}

}
