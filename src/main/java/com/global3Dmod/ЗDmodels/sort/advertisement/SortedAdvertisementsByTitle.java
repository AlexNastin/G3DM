package com.global3Dmod.�Dmodels.sort.advertisement;

import java.util.Comparator;

import com.global3Dmod.�Dmodels.domain.Advertisement;
import com.global3Dmod.�Dmodels.domain.Post;

public class SortedAdvertisementsByTitle implements Comparator<Advertisement>{

	@Override
	public int compare(Advertisement obj1, Advertisement obj2) {
		String title1 = obj1.getTitle();
        String title2 = obj2.getTitle();
        return title1.compareTo(title2);
	}

}
