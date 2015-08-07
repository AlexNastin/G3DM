package com.global3Dmod.ÇDmodels.sort.country;

import java.util.Comparator;

import com.global3Dmod.ÇDmodels.domain.Country;

public class SortedCountriesById implements Comparator<Country>{

	@Override
	public int compare(Country obj1, Country obj2) {
		int country1 = obj1.getIdCountry();
        int country2 = obj2.getIdCountry();
        if(country2 > country1) {
            return -1;
        }
        else if(country2 < country1) {
            return 1;
        }
        else {
            return 0;
        }
	}
}
