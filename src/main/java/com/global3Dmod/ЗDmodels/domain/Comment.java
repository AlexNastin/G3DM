package com.global3Dmod.«Dmodels.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@NamedQueries({
	@NamedQuery(name="—omment.findAll", query="select c from Comment c"),
	@NamedQuery(name="Comment.findByPost", query="select c from Comment c join fetch c.user where c.post_idPost = :post_idPost")})
public class Comment implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1553486589409738413L;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_user", insertable=false, updatable=false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id_post", insertable=false, updatable=false)
	private Post post;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + id—omment;
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + post_idPost;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (post_idPost != other.post_idPost)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id—omment=" + id—omment + ", user_idUser="
				+ user_idUser + ", post_idPost=" + post_idPost + ", dateTime="
				+ dateTime + ", text=" + text + ", user=" + user + ", post="
				+ post + "]";
	}

	

}
