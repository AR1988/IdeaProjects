package com.company.comparator;

import com.company.CountryCode;
import com.company.collection.OurArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountryCodeComparatorTest<E> {

    @Test
    public void testMax_severalIntegers() {
        OurArrayList list = new OurArrayList();

        list.append(105);
        list.append(15);
        list.append(2);
        list.append(25);

        AbstractComparator comparator = new IntegerComparator();

        assertEquals(105, list.max(comparator));
    }

    @Test
    public void testMin_severalIntegers() {
        OurArrayList list = new OurArrayList();

        list.append(105);
        list.append(15);
        list.append(2);
        list.append(25);
        list.append(-5);

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
        list.append(200);  //5
        list.append(-50);  //0
        list.append(1);    //2
        list.append(0);    //1
        list.append(8);    //3
        list.append(9);    //4

        list.sort(new IntegerComparator());
        assertEquals(-50, list.get(0));
        assertEquals(0, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(8, list.get(3));
        assertEquals(9, list.get(4));
        assertEquals(200, list.get(5));
    }
}
