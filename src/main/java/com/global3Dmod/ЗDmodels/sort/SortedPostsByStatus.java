package com.global3Dmod.ÇDmodels.sort;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Post;

public class SortedPostsByStatus implements Comparator<Post>{

	@Override
	public int compare(Post obj1, Post obj2) {
//		int status1 = obj1.getIsDisplay();
//        int status2 = obj2.getIsDisplay();
//        if(status1==1 && status2==false) {
//            return 1;
//        }
//        else if(status1==false && status2==true) {
//            return -1;
//        }
//        else {
            return 0;
        }
}
