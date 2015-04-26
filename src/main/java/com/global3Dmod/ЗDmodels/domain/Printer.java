package com.global3Dmod.ÇDmodels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Table(name = "PRINTERS")
@NamedQuery(name="Printer.findAll", query="select p from Printer p")
public class Printer implements Essence {

	@Id
	@Column(name = "idPrinter")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrinter;
	
	@Column(name = "title")
	private String title;
	
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
