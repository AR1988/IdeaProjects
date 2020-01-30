package com.company.collections;


import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;


public class OurHashMapTest {


    @Test
    public void testPut_checkWithJavaHashmap() {
        OurMap<String, String> hm = new NewHashMap<>();

        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");
        hm.put("four", "4");
        hm.put("five", "5");
        hm.put("six", "6");

        HashMap<String,String>hmTest = new HashMap<>();
        hmTest.put("one", "1");
        hmTest.put("two", "2");
        hmTest.put("three", "3");
        hmTest.put("four", "4");
        hmTest.put("five", "5");
        hmTest.put("six", "6");

        assertEquals(hm.size(),hmTest.size());
        assertEquals(hm.contains("one"),hmTest.containsKey("one"));
        assertEquals(hm.contains("tree"),hmTest.containsKey("tree"));
    }

    @Test
    public void testGet_inList() {
        OurMap<String, String> hm = new NewHashMap<>();
        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");
        hm.put("four", "4");
        hm.put("five", "5");
        hm.put("six", "6");

        assertEquals(hm.get("one"), "1");
        assertEquals(hm.get("two"), "2");
        assertEquals(hm.get("three"), "3");
        assertEquals(hm.get("four"), "4");
        assertEquals(hm.get("five"), "5");
        assertEquals(hm.get("six"), "6");

        assertNull(hm.get("null"));
    }

    @Test
    public void testGet_notInList() {
        OurMap<String, String> hm = new NewHashMap<>();
        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");
        hm.put("four", "4");
        hm.put("five", "5");
        hm.put("six", "6");

        assertNull(hm.get("ten"));
        assertNull(hm.get("eleven"));
        assertNull(hm.get("null"));
    }

    @Test
    public void testContains_inList_true() {
        OurMap<String, String> hm = new NewHashMap<>();
        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");
        hm.put("four", "4");
        hm.put("five", "5");
        hm.put("six", "6");

        assertTrue(hm.contains("one"));
        assertTrue(hm.contains("two"));
        assertTrue(hm.contains("three"));
    }

    @Test
    public void testContains_inList_false() {
        OurMap<String, String> hm = new NewHashMap<>();
        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");

        assertFalse(hm.contains("ten"));
        assertFalse(hm.contains("eleven"));
        assertFalse(hm.contains("twelve"));
    }

    @Test
    public void testRemove_inList_checkWithSizeAndContains() {
        OurMap<String, String> hm = new NewHashMap<>();
        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");
        hm.put("four", "4");
        hm.put("five", "5");
        hm.put("six", "6");

        assertEquals(hm.size(), 6);
        assertTrue(hm.contains("one"));
        assertTrue(hm.remove("one"));
        assertFalse(hm.contains("one"));
        assertEquals(hm.size(), 5);

        assertEquals(hm.size(), 5);
        assertTrue(hm.contains("three"));
        assertTrue(hm.remove("three"));
        assertFalse(hm.contains("three"));
        assertEquals(hm.size(), 4);
    }

    @Test
    public void testRemove_notInLins_checkWithSize() {
        OurMap<String, String> hm = new NewHashMap<>();
        hm.put("one", "1");
        hm.put("two", "2");

        assertEquals(hm.size(), 2);
        assertFalse(hm.remove("ten"));
        assertEquals(hm.size(), 2);
    }

    @Test
    public void testSize_checkWithPut() {
        OurMap<String, String> hm = new NewHashMap<>();
        hm.put("one", "1");
        assertEquals(hm.size(), 1);

        hm.put("two", "2");
        assertEquals(hm.size(), 2);

        hm.put("three", "3");
        assertEquals(hm.size(), 3);

        hm.put("four", "4");
        assertEquals(hm.size(), 4);

        hm.put("five", "5");
        assertEquals(hm.size(), 5);

        hm.put("six", "6");
        assertEquals(hm.size(), 6);
    }

    @Test
    public void testSize_checkWithRemove() {
        OurMap<String, String> hm = new NewHashMap<>();
        assertEquals(hm.size(),0);
        hm.put("one", "1");
        hm.put("two", "2");
        hm.put("three", "3");
        hm.put("four", "4");
        hm.put("five", "5");
        hm.put("six", "6");

        assertEquals(hm.size(),6);

        hm.remove("one");
        assertEquals(hm.size(),5);

        hm.remove("two");
        assertEquals(hm.size(),4);

        hm.remove("five");
        assertEquals(hm.size(),3);

        hm.remove("four");
        assertEquals(hm.size(),2);
    }
}