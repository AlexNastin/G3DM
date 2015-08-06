package com.global3Dmod.ÇDmodels.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "categories")
@NamedQueries({
		@NamedQuery(name = "Category.findAll", query = "select c from Category c"),
		@NamedQuery(name = "Category.findCategoryById", query = "select c from Category c join fetch c.subcategories where c.idCategory = :idCategory") })
public class Category implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8317281787365057557L;

	@Id
	@Column(name = "id_category")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;

	@Column(name = "title")
	private String title;

	@Column(name = "image_path")
	private String imagePath;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Subcategory> subcategories = new ArrayList<Subcategory>();

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Post> posts;

	public Category() {
		super();
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCategory;
		result = prime * result
				+ ((imagePath == null) ? 0 : imagePath.hashCode());
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
		Category other = (Category) obj;
		if (idCategory != other.idCategory)
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
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
		return "Category [idCategory=" + idCategory + ", title=" + title
				+ ", imagePath=" + imagePath + "]";
	}

}
