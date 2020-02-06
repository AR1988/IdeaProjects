package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseCaseTest {
    @Test
    public void charsReplace_assertUpperLowerCases() {
        ReverseCase reverseCase1 = new ReverseCase("aaAAa");
        ReverseCase reverseCase2 = new ReverseCase("aAaaa");
        ReverseCase reverseCase3 = new ReverseCase("aaAaa");
        ReverseCase reverseCase4 = new ReverseCase("aaaAa");
        ReverseCase reverseCase5 = new ReverseCase("aaaaA");
        ReverseCase reverseCase6 = new ReverseCase("AAAAA");
        ReverseCase reverseCase7 = new ReverseCase("aaaaa");

        ReverseCase reverseCase10 = new ReverseCase("aaaaa1");
        ReverseCase reverseCase11 = new ReverseCase("1aaaaa1");
        ReverseCase reverseCase12 = new ReverseCase("1aaaaa");

        assertEquals(reverseCase1.charsCompare(), "AAaaA");
        assertEquals(reverseCase2.charsCompare(), "AaAAA");
        assertEquals(reverseCase3.charsCompare(), "AAaAA");
        assertEquals(reverseCase4.charsCompare(), "AAAaA");
        assertEquals(reverseCase5.charsCompare(), "AAAAa");
        assertEquals(reverseCase6.charsCompare(), "aaaaa");
        assertEquals(reverseCase7.charsCompare(), "AAAAA");

        assertEquals(reverseCase10.charsCompare(), "AAAAA1");
        assertEquals(reverseCase11.charsCompare(), "1AAAAA1");
        assertEquals(reverseCase12.charsCompare(), "1AAAAA");
    }
}