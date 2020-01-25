package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Palindrome {


    private String source;

    public Palindrome(String source) {
        this.source = source;
    }

    private char[] toChar() {
        return source.toLowerCase().toCharArray();
    }

    private char[] toCharReverse() {
        char[] charArray1 = toChar();
        char[] charArray2 = new char[charArray1.length];

        for (int i = 0; i < charArray1.length; i++) {
            charArray2[i] = charArray1[charArray1.length - 1 - i];
        }
        return charArray2;
    }

    public boolean isStringPalindrome() {
        return Arrays.equals(toChar(), toCharReverse());
    }
}
