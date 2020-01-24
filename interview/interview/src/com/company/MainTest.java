package com.company;

import org.junit.Test;

import static com.company.Main.*;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void Nod() {
        assertEquals(9, gcd(225, 126));
        assertEquals(1, gcd(755, 589));
        assertEquals(4, gcd(28, 16));
        assertEquals(25, gcd(125, 100));
        assertEquals(5, gcd(75, 55));
        assertEquals(6, gcd(12, 6));
        assertEquals(1, gcd(8, 3));

        assertEquals(-1, gcd(3, 10));
        assertEquals(-1, gcd(1, 3));
    }

    @Test
    public void Nok() {
        assertEquals(3150, lcm(225, 126));
        assertEquals(444695, lcm(755, 589));
        assertEquals(112, lcm(28, 16));
        assertEquals(500, lcm(125, 100));
        assertEquals(825, lcm(75, 55));
        assertEquals(12, lcm(12, 6));
        assertEquals(24, lcm(8, 3));

        assertEquals(-1, gcd(3, 10));
        assertEquals(-1, gcd(1, 3));
    }

    @Test
    public void result() {
        assertEquals(6, task3(28));
        assertEquals(2, task3(20));
        assertEquals(3, task3(21));
        assertEquals(4, task3(4));
        assertEquals(1, task3(1));
        assertEquals(5, task3(9));
        assertEquals(11, task3(101));
        assertEquals(0, task3(0));
    }

    @Test
    public void testTask4() {
        assertEquals(1, task4(1));       // 1
        assertEquals(1, task4(2));     // 2
        assertEquals(2, task4(3));       // 1+2
        assertEquals(2, task4(4));       // 1+3
        assertEquals(2, task4(5));       // 1+4

        assertEquals(3, task4(6));       // 1+2+3
        assertEquals(3, task4(7));       // 1+2+4
        assertEquals(3, task4(8));       // 1+2+5
        assertEquals(3, task4(9));       // 1+2+6

        assertEquals(4, task4(10));       // 1+2+3+4
        assertEquals(4, task4(11));      // 1+2+3+5

        assertEquals(6, task4(22));      // 1+2+3+4+5+7
        assertEquals(9, task4(51));      // 1+2+3+4+5+6+7+8+19
    }
}