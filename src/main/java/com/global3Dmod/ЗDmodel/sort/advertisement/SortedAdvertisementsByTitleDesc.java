package com.global3Dmod.�Dmodel.sort.advertisement;

import java.util.Comparator;

import com.global3Dmod.�Dmodel.domain.Advertisement;

public class SortedAdvertisementsByTitleDesc implements Comparator<Advertisement>{

	@Override
	public int compare(Advertisement obj1, Advertisement obj2) {
		String title1 = obj1.getTitle();
        String title2 = obj2.getTitle();
        return title2.compareTo(title1);
	}

}
