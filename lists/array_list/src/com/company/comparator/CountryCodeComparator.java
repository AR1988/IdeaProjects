package com.company.comparator;

import com.company.CountryCode;


public class CountryCodeComparator<E> extends AbstractComparator<E> {


    @Override
    public int compare(E o1, E o2) {
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
