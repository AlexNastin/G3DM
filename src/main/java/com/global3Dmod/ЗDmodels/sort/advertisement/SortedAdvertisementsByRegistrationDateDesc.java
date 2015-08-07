package com.global3Dmod.ÇDmodels.sort.advertisement;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Advertisement;

public class SortedAdvertisementsByRegistrationDateDesc implements Comparator<Advertisement>{

	@Override
	public int compare(Advertisement obj1, Advertisement obj2) {
		String date1 = obj1.getRegistrationDate();
        String date2 = obj2.getRegistrationDate();
        return date1.compareTo(date2);
	}

}
