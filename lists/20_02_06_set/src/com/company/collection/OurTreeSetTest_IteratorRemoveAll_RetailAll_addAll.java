package com.company.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class OurTreeSetTest_IteratorRemoveAll_RetailAll_addAll {

    OurSet<Integer> ourSource = new OurTreeSet<>();
    OurSet<Integer> ourSource2 = new OurTreeSet<>();

    @Test
    public void addAll() {
        Set<Integer> set1 = getset1();
        Set<Integer> set2 = getset2();

        ourSource = getOurs1();
        ourSource2 = getOurs2();

        ourSource.addAll(ourSource2);
        set1.addAll(set2);

        assertEquals(set1.size(), ourSource.size());
        assertArrayEquals(setToArray(set1), ourSetToArray(ourSource));
    }

    @Test
    public void removeAll() {
        Set<Integer> set1 = getset1();
        Set<Integer> set2 = getset2();

        ourSource = getOurs1();
        ourSource2 = getOurs2();

        ourSource.removeAll(ourSource2);
        set1.removeAll(set2);

        assertEquals(set1.size(), ourSource.size());
        assertArrayEquals(setToArray(set1), ourSetToArray(ourSource));
    }

    @Test
    public void retainAll() {
        Set<Integer> set1 = getset1();
        Set<Integer> set2 = getset2();

        ourSource = getOurs1();
        ourSource2 = getOurs2();

        ourSource.retainAll(ourSource2);
        set1.retainAll(set2);

        assertEquals(set1.size(), ourSource.size());
        assertArrayEquals(setToArray(set1), ourSetToArray(ourSource));
    }


    @Test
    public void iterator() {
        int[] source1 = ourSetToArray(getOursRandom());
        int[] source2 = {1, 2, 7, 8, 9, 10, 12, 13, 14, 16, 20};


        assertArrayEquals(source1, source2);
    }

    private int[] setToArray(Set<Integer> set) {
        int[] res = new int[set.size()];
        int count = 0;
        for (Integer integer : set)
            res[count++] = integer;
        return res;
    }

    private int[] ourSetToArray(OurSet<Integer> set) {
        int[] res = new int[set.size()];
        int count = 0;
        for (Integer integer : set)
            res[count++] = integer;
        return res;
    }

    public static Set<Integer> getset1() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        return set;
    }

    public static Set<Integer> getset2() {
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(10);
        set.add(11);
        return set;
    }

    public static OurSet<Integer> getOurs1() {
        OurSet<Integer> set = new OurTreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        return set;
    }

    public static OurSet<Integer> getOurs2() {
        OurSet<Integer> set = new OurTreeSet<>();
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(10);
        set.add(11);
        return set;
    }

    public static OurSet<Integer> getOursRandom() {
        OurSet<Integer> set = new OurTreeSet<>();
        set.add(10);
        set.add(8);
        set.add(7);
        set.add(9);
        set.add(2);
        set.add(13);
        set.add(12);
        set.add(14);
        set.add(20);
        set.add(16);
        set.add(1);
        return set;
    }
}