package com.global3Dmod.ÇDmodels.sort;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByTitleDesc implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		String title1 = obj1.getTitle();
        String title2 = obj2.getTitle();
        return title2.compareTo(title1);
	}

}
