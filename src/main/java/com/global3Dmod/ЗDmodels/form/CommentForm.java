package com.global3Dmod.ÇDmodels.form;

import com.global3Dmod.ÇDmodels.domain.Essence;

public class CommentForm implements Essence {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4369670076082219375L;

	private String comment;
	
	private int idPost;
	
	public CommentForm() {
		super();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + idPost;
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
		CommentForm other = (CommentForm) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (idPost != other.idPost)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentForm [comment=" + comment + ", idPost=" + idPost + "]";
	}

}
