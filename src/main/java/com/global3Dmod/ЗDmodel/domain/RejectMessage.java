package com.global3Dmod.�Dmodel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.global3Dmod.�Dmodel.domain.Essence;

@Entity
@Table(name = "reject_message")
@NamedQueries({
		@NamedQuery(name="RejectMessage.findAll", query="select m from RejectMessage m"),
		@NamedQuery(name="RejectMessage.findByPost", query="select m from RejectMessage m where m.post.idPost = :post_idPost")})
public class RejectMessage implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1231853720761575653L;

	@Id
	@Column(name = "id_message")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;

	@Column(name = "message")
	private String message;
	
	@Column(name = "user_id_user")
	private int user_idUser;
	
	@OneToOne
	@JoinColumn(name = "post_id_post")
	private Post post;
	
	@JoinColumn(name = "user_id_user", referencedColumnName = "id_user", insertable=false, updatable=false)
	@ManyToOne(optional = false)
	private User user;
	
	public RejectMessage() {
		super();
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMessage;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
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
		RejectMessage other = (RejectMessage) obj;
		if (idMessage != other.idMessage)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
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
		return "RejectMessage [idMessage=" + idMessage + ", message=" + message
				+ ", user_idUser=" + user_idUser + "]";
	}

	
}
