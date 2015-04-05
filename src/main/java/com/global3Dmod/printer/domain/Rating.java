package com.global3Dmod.printer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.global3Dmod.printer.domain.Essence;

@Entity
@Table(name = "RATINGS")
@NamedQuery(name="Rating.findAll", query="select r from Rating r")
public class Rating implements Essence {

	public Rating() {
		super();
	}

	@Id
	@Column(name = "idRating")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRating;
	
	@Column(name = "post_idPost")
	private int post_idPost;

	@Column(name = "rating")
	private int rating;

	public int getIdRating() {
		return idRating;
	}

	public void setIdRating(int idRating) {
		this.idRating = idRating;
	}

	public int getPost_idPost() {
		return post_idPost;
	}

	public void setPost_idPost(int post_idPost) {
		this.post_idPost = post_idPost;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRating;
		result = prime * result + post_idPost;
		result = prime * result + rating;
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
		Rating other = (Rating) obj;
		if (idRating != other.idRating)
			return false;
		if (post_idPost != other.post_idPost)
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}
	
}
