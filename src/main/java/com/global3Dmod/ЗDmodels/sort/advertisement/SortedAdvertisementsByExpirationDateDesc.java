package com.global3Dmod.ÇDmodels.sort.advertisement;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Advertisement;

public class SortedAdvertisementsByExpirationDateDesc implements Comparator<Advertisement>{

	@Override
	public int compare(Advertisement obj1, Advertisement obj2) {
		String date1 = obj1.getExpirationDate();
        String date2 = obj2.getExpirationDate();
        return date1.compareTo(date2);
	}

}
