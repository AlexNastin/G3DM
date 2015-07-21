package com.global3Dmod.ÇDmodels.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "printers")
@NamedQueries({
	@NamedQuery(name="Printer.findAll", query="select p from Printer p"),
	@NamedQuery(name="Printer.findCheckById", query="select p from Printer p where p.idPrinter in (:idPrinters)") })
public class Printer implements Essence {

	@Id
	@Column(name = "id_printer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrinter;
	
	@Column(name = "title")
	private String title;
	
	@ManyToMany(mappedBy="printers")
	private List<Post> posts;
	
	public Printer() {
		super();
	}

	public int getIdPrinter() {
		return idPrinter;
	}

	public void setIdPrinter(int idPrinter) {
		this.idPrinter = idPrinter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPrinter;
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
		Printer other = (Printer) obj;
		if (idPrinter != other.idPrinter)
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
		return "Printer [idPrinter=" + idPrinter + ", title=" + title + "]";
	}
	
	

}
