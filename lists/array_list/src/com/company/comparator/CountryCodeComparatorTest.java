package com.company.comparator;

import com.company.CountryCode;
import com.company.collection.OurArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountryCodeComparatorTest {

    @Test
    public void testMax_severalIntegers() {
        OurArrayList list = new OurArrayList();

        list.add(105);
        list.add(15);
        list.add(2);
        list.add(25);

        AbstractComparator comparator = new IntegerComparator();

        assertEquals(105, list.max(comparator));
    }

    @Test
    public void testMin_severalIntegers() {
        OurArrayList list = new OurArrayList();

        list.add(105);
        list.add(15);
        list.add(2);
        list.add(25);
        list.add(-5);

        AbstractComparator comparator = new IntegerComparator();

        assertEquals(-5, list.min(comparator));
    }

    @Test
    public void testComparatorCC() {
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode china = new CountryCode("China", 86);
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode italy = new CountryCode("Italy", 39);
        CountryCode germany = new CountryCode("Germany", 49);

        AbstractComparator compare = new CountryCodeComparator();

        assertEquals(-1, (compare.compare(russia, china)));
        assertEquals(0, (compare.compare(russia, russia)));
        assertEquals(1, (compare.compare(china, russia)));
    }

    @Test
    public void testSort() {

        OurArrayList list = new OurArrayList();
        list.add(200);  //5
        list.add(-50);  //0
        list.add(1);    //2
        list.add(0);    //1
        list.add(8);    //3
        list.add(9);    //4

        list.sort(new IntegerComparator());
        assertEquals(-50, list.get(0));
        assertEquals(0, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(8, list.get(3));
        assertEquals(9, list.get(4));
        assertEquals(200, list.get(5));
    }
}
