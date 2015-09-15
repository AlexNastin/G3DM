package com.global3Dmod.�Dmodel.sort.post;

import java.util.Comparator;

import com.global3Dmod.�Dmodel.domain.Post;

public class SortedPostsByDate implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		String date1 = obj1.getDateUpdate();
        String date2 = obj2.getDateUpdate();
        return date2.compareTo(date1);
	}

}
