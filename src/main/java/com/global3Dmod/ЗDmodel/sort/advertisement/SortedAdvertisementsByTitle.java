package com.global3Dmod.ÇDmodel.sort.advertisement;

import java.util.Comparator;

import com.global3Dmod.ÇDmodel.domain.Advertisement;

public class SortedAdvertisementsByTitle implements Comparator<Advertisement>{

	@Override
	public int compare(Advertisement obj1, Advertisement obj2) {
		String title1 = obj1.getTitle();
        String title2 = obj2.getTitle();
        return title1.compareTo(title2);
	}

}
