package com.global3Dmod.ÇDmodels.sort.post;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByComplainDesc implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
		int complain1 = obj1.getComplain();
        int complain2 = obj2.getComplain();
        if(complain1 > complain2) {
            return 1;
        }
        else if(complain1 < complain2) {
            return -1;
        }
        else {
            return 0;
        }
	}

}
