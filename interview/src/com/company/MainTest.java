package com.company;

import org.junit.Test;

import static com.company.Main.*;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void result() {
        assertEquals(6,task3(28));
        assertEquals(2,task3(20));
        assertEquals(3,task3(21));
        assertEquals(4,task3(4));
        assertEquals(1,task3(1));
        assertEquals(5,task3(9));
        assertEquals(11,task3(101));
        assertEquals(0,task3(0));
    }

    @Test
    public void testTask4() {
        assertEquals(1,task4(1));       // 1
        assertEquals(1,task4(2));     // 2
        assertEquals(2,task4(3));       // 1+2
        assertEquals(2,task4(4));       // 1+3
        assertEquals(2,task4(5));       // 1+4

        assertEquals(3,task4(6));       // 1+2+3
        assertEquals(3,task4(7));       // 1+2+4
        assertEquals(3,task4(8));       // 1+2+5
        assertEquals(3,task4(9));       // 1+2+6

        assertEquals(4,task4(10));       // 1+2+3+4
        assertEquals(4,task4(11));      // 1+2+3+5

        assertEquals(6,task4(22));      // 1+2+3+4+5+7
        assertEquals(9,task4(51));      // 1+2+3+4+5+6+7+8+19
    }
}