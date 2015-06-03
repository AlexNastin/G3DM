package com.global3Dmod.ÇDmodels.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByTitle implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		String title1 = obj1.getTitle();
        String title2 = obj2.getTitle();
        return title1.compareTo(title2);
	}

}
