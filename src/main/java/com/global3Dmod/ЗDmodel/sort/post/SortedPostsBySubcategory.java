package com.global3Dmod.ÇDmodel.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodel.domain.Post;
import com.global3Dmod.ÇDmodel.domain.Subcategory;

public class SortedPostsBySubcategory implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		Subcategory subcategory1 = obj1.getSubcategory();
		Subcategory subcategory2 = obj2.getSubcategory();
		String title1 = subcategory1.getTitle();
        String title2 = subcategory2.getTitle();
        return title1.compareTo(title2);
	}

}
