package com.global3Dmod.ÇDmodels.sort;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Category;
import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByCategory implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		Category category1 = obj1.getCategory();
		Category category2 = obj2.getCategory();
		String title1 = category1.getTitle();
        String title2 = category2.getTitle();
        return title1.compareTo(title2);
	}

}
