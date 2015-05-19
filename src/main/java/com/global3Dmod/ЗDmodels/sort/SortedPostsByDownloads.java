package com.global3Dmod.�Dmodels.sort;

import java.util.Comparator;

import com.global3Dmod.�Dmodels.domain.Post;

public class SortedPostsByDownloads implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		int count1 = obj1.getCountDownload();
        int count2 = obj2.getCountDownload();
        if(count1 > count2) {
            return 1;
        }
        else if(count1 < count2) {
            return -1;
        }
        else {
            return 0;
        }
	}

}
