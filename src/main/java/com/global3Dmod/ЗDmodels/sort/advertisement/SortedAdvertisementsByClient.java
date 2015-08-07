package com.global3Dmod.ÇDmodels.sort.advertisement;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Advertisement;

public class SortedAdvertisementsByClient implements Comparator<Advertisement>{

	@Override
	public int compare(Advertisement obj1, Advertisement obj2) {
		String client1 = obj1.getClient();
        String client2 = obj2.getClient();
        return client1.compareTo(client2);
	}

}
