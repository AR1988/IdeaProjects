package com.company.collection;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class OurTreeSetTest {

    OurSet<Integer> ourSource = new OurTreeSet<>();
    OurSet<Integer> ourNewSource = new OurTreeSet<>();
    
    TreeSet<Integer> javaSource = new TreeSet<>();

    @Test
    public void add() {

        assertEquals(ourSource.add(10), javaSource.add(10));
        assertEquals(ourSource.add(15), javaSource.add(15));
        assertEquals(ourSource.add(9), javaSource.add(9));
        assertEquals(ourSource.add(7), javaSource.add(7));
        assertEquals(ourSource.add(1), javaSource.add(1));

        assertEquals(ourSource.add(10), javaSource.add(10));
        assertEquals(ourSource.add(15), javaSource.add(15));
        assertEquals(ourSource.add(9), javaSource.add(9));
        assertEquals(ourSource.add(7), javaSource.add(7));
        assertEquals(ourSource.add(1), javaSource.add(1));

    }

    @Test
    public void remove() {
    }

    @Test
    public void contains() {
        ourSource.add(10);
        ourSource.add(9);
        ourSource.add(7);
        ourSource.add(11);
        ourSource.add(15);

        javaSource.add(10);
        javaSource.add(9);
        javaSource.add(7);
        javaSource.add(11);
        javaSource.add(15);

        assertEquals(javaSource.contains(10), ourSource.contains(10));
        assertEquals(javaSource.contains(9), ourSource.contains(9));
        assertEquals(javaSource.contains(7), ourSource.contains(7));
        assertEquals(javaSource.contains(111), ourSource.contains(111));
        assertEquals(javaSource.contains(15), ourSource.contains(15));

        assertEquals(javaSource.contains(100), ourSource.contains(100));
        assertEquals(javaSource.contains(90), ourSource.contains(90));
        assertEquals(javaSource.contains(70), ourSource.contains(70));
        assertEquals(javaSource.contains(110), ourSource.contains(110));
        assertEquals(javaSource.contains(105), ourSource.contains(105));
    }

    @Test
    public void size() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void removeAll() {
       
            ourSource.add(10);
            ourSource.add(8);
            ourSource.add(7);
            ourSource.add(9);
            ourSource.add(13);
            ourSource.add(14); 
            ourSource.add(15);

            ourNewSource.add(10);
            ourNewSource.add(8);
            ourNewSource.add(7);
            ourNewSource.add(9);
            ourNewSource.add(13);
            ourNewSource.add(14);
            ourNewSource.add(15);

            

        assertTrue(ourSource.remove(13));
        javaSource.remove(13);
        System.out.println();
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void iterator() {
    }
}