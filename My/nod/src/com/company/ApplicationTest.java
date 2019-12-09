package com.company;

import org.junit.Test;

import static com.company.Application.*;
import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void testNod (){
        assertEquals(1, nod(267,125));
        assertEquals(1, nod(1520,357));
        assertEquals(400, nod(400,800));
        assertEquals(110, nod(550,660));
        assertEquals(4, nod(68,88));

    }

    @Test
    public void testNok() {
        assertEquals(33375, nok(267,125));
        assertEquals(542640, nok(1520,357));
        assertEquals(800, nok(400,800));
        assertEquals(3300, nok(550,660));
        assertEquals(1496, nok(68,88));
    }
}