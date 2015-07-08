package com.global3Dmod.ÇDmodels.form;

import com.global3Dmod.ÇDmodels.domain.Essence;

public class CommentForm implements Essence {
	
	private String text;
	
	private int idPost;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
		result = prime * result + idPost;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		if (idPost != other.idPost)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentForm [text=" + text + ", idPost=" + idPost + "]";
	}

	

	
}
