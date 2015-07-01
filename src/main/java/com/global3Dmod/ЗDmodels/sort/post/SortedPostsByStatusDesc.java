package com.global3Dmod.ÇDmodels.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByStatusDesc implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		int status1 = obj1.getIsDisplay();
        int status2 = obj2.getIsDisplay();
        if(status1 > status2) {
            return 1;
        }
        else if(status1 < status2) {
            return -1;
        }
        else {
            return 0;
        }
	}
}
