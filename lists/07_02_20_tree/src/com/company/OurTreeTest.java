package com.company;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class OurTreeTest {

    @Test
    public void size() {
        OurTree ot = new OurTree();
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i < 100; i++) {
            ts.add(i);
            ot.add(i);
        }

        System.out.println(ot.findHeight()));
    }
}