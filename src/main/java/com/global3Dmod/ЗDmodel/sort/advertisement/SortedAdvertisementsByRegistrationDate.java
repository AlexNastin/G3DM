package com.global3Dmod.�Dmodel.sort.advertisement;

import java.util.Comparator;

import com.global3Dmod.�Dmodel.domain.Advertisement;

public class SortedAdvertisementsByRegistrationDate implements Comparator<Advertisement>{

	@Override
	public int compare(Advertisement obj1, Advertisement obj2) {
		String date1 = obj1.getRegistrationDate();
        String date2 = obj2.getRegistrationDate();
        return date2.compareTo(date1);
	}

}
