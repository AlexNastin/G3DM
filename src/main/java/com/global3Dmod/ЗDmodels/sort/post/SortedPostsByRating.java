package com.global3Dmod.ÇDmodels.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByRating implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		int rating1 = obj1.getRating();
        int rating2 = obj2.getRating();
        if(rating2 > rating1) {
            return 1;
        }
        else if(rating2 < rating1) {
            return -1;
        }
        else {
            return 0;
        }
	}

}
