package com.global3Dmod.«Dmodels.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@NamedQuery(name="—omment.findAll", query="select c from Comment c")
public class Comment implements Essence {

	@Id
	@Column(name = "id_comment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id—omment;

	@Column(name = "user_id_user")
	private int user_idUser;
	
	@Column(name = "post_id_post")
	private int post_idPost;
	
	@Column(name = "date_time")
	private Date dateTime;
	
	@Column(name = "text")
	private String text;

	public Comment() {
		super();
	}

	public int getId—omment() {
		return id—omment;
	}

	public void setId—omment(int id—omment) {
		this.id—omment = id—omment;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public int getPost_idPost() {
		return post_idPost;
	}

	public void setPost_idPost(int post_idPost) {
		this.post_idPost = post_idPost;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + id—omment;
		result = prime * result + post_idPost;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Comment other = (Comment) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (id—omment != other.id—omment)
			return false;
		if (post_idPost != other.post_idPost)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "—omment [id—omment=" + id—omment + ", user_idUser="
				+ user_idUser + ", post_idPost=" + post_idPost + ", dateTime="
				+ dateTime + ", text=" + text + "]";
	}

}
