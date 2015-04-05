package com.global3Dmod.printer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.global3Dmod.printer.domain.Essence;

@Entity
@Table(name = "DISPROGRAMS")
@NamedQuery(name="DisProgram.findAll", query="select d from DisProgram d")
public class DisProgram implements Essence {

	@Id
	@Column(name = "idDisProgram")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDisProgram;
	
	@Column(name = "title")
	private String title;
	
	public DisProgram() {
		super();
	}

	public int getIdDisProgram() {
		return idDisProgram;
	}

	public void setIdDisProgram(int idDisProgram) {
		this.idDisProgram = idDisProgram;
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
		result = prime * result + idDisProgram;
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
		DisProgram other = (DisProgram) obj;
		if (idDisProgram != other.idDisProgram)
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
		return "DisProgram [idDisProgram=" + idDisProgram + ", title=" + title
				+ "]";
	}
	
	

}
