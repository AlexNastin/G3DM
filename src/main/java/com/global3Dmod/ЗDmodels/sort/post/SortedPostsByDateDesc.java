package com.global3Dmod.ÇDmodels.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByDateDesc implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		String date1 = obj1.getDateUpdate();
        String date2 = obj2.getDateUpdate();
        return date1.compareTo(date2);
	}

}
