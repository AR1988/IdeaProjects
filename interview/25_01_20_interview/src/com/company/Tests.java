package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void isStringPalindrome_assertTrue() {
        Palindrome palindrome1 = new Palindrome("Deed"); //true
        Palindrome palindrome2 = new Palindrome("Level"); //true
        Palindrome palindrome3 = new Palindrome("Malayalam"); //true
        Palindrome palindrome4 = new Palindrome("PEEP"); //true
        Palindrome palindrome5 = new Palindrome("SaGas"); //true

        Palindrome palindrome6 = new Palindrome("Hello"); //true
        Palindrome palindrome7 = new Palindrome("world"); //true
        Palindrome palindrome8 = new Palindrome("String"); //true
        Palindrome palindrome9 = new Palindrome("Class"); //true

        assertTrue(palindrome1.isStringPalindrome());
        assertTrue(palindrome2.isStringPalindrome());
        assertTrue(palindrome3.isStringPalindrome());
        assertTrue(palindrome4.isStringPalindrome());
        assertTrue(palindrome5.isStringPalindrome());
    }

    @Test
    public void isStringPalindrome_assertFalse() {
        Palindrome palindrome1 = new Palindrome("Hello"); //false
        Palindrome palindrome2 = new Palindrome("world"); //false
        Palindrome palindrome3 = new Palindrome("String"); //false
        Palindrome palindrome4 = new Palindrome("Class"); //false
        Palindrome palindrome5 = new Palindrome("clock"); //false

        assertFalse(palindrome1.isStringPalindrome());
        assertFalse(palindrome2.isStringPalindrome());
        assertFalse(palindrome3.isStringPalindrome());
        assertFalse(palindrome4.isStringPalindrome());
        assertFalse(palindrome5.isStringPalindrome());
    }
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