package com.global3Dmod.ÇDmodel.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodel.domain.Post;

public class SortedPostsByStatus implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		int status1 = obj1.getIsDisplay();
        int status2 = obj2.getIsDisplay();
        if(status2 > status1) {
            return 1;
        }
        else if(status2 < status1) {
            return -1;
        }
        else {
            return 0;
        }
	}
}
