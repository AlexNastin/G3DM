package com.global3Dmod.ÇDmodels.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByRatingDesc implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		int rating1 = obj1.getRating();
        int rating2 = obj2.getRating();
        if(rating1 > rating2) {
            return 1;
        }
        else if(rating1 < rating2) {
            return -1;
        }
        else {
            return 0;
        }
	}

}
