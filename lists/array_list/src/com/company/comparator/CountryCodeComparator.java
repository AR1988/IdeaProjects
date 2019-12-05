package com.company.comparator;

import com.company.CountryCode;


public class CountryCodeComparator extends AbstractComparator {


    @Override
    public int compare(Object o1, Object o2) {
        CountryCode x = (CountryCode) o1;
        CountryCode y = (CountryCode) o2;

//        if (x.getCountryCode() < y.getCountryCode())
//            return -1;
//        else if (x.getCountryCode() > y.getCountryCode())
//            return 1;
//        return 0;
        return x.getCountryCode() - y.getCountryCode();
        
    }
}
