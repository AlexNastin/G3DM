package com.global3Dmod.ÇDmodels.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subcategories")
@NamedQueries({
	@NamedQuery(name = "Subcategory.findTop3", query = "select s from Subcategory s where s.category_idCategory = :idCategory and s.top=true"),
	@NamedQuery(name="Subcategory.findAll", query="select s from Subcategory s")})
public class Subcategory implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4589911983435569304L;

	@Id
	@Column(name = "id_subcategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubcategory;

	@Column(name = "category_id_category")
	private int category_idCategory;

	@Column(name = "title")
	private String title;
	
	@Column(name = "top")
	private boolean top;
	
	@JoinColumn(name = "category_id_category", referencedColumnName = "id_category", insertable=false, updatable=false)
	@ManyToOne(optional = false)
	private Category category;
	
	@OneToMany(mappedBy = "subcategory")
	private List<Post> posts;

	public Subcategory() {
		super();
	}

	public int getIdSubcategory() {
		return idSubcategory;
	}

	public void setIdSubcategory(int idSubcategory) {
		this.idSubcategory = idSubcategory;
	}

	public int getCategory_idCategory() {
		return category_idCategory;
	}

	public void setCategory_idCategory(int category_idCategory) {
		this.category_idCategory = category_idCategory;
	}

	public String getTitle() {
		return title;
	}
	
	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + category_idCategory;
		result = prime * result + idSubcategory;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (top ? 1231 : 1237);
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (category_idCategory != other.category_idCategory)
			return false;
		if (idSubcategory != other.idSubcategory)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (top != other.top)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subcategory [idSubcategory=" + idSubcategory
				+ ", category_idCategory=" + category_idCategory + ", title="
				+ title + ", top=" + top + ", category=" + category + "]";
	}
	
}
