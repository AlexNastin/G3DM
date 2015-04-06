package com.global3Dmod.printer.dao;

import java.util.List;

import com.global3Dmod.printer.domain.Post;

public interface IPostDAO {
	
	public void update(Post post);

	public void add(Post post);

	public List<Post> getAllPosts();

	public void remove(Integer id);

}
