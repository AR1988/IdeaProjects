package com.company;

import com.company.collection.EmptyListException;


import java.util.Arrays;

public class Application {

    public static void main(String[] args) throws EmptyListException {
        // write your code here
        char c;
        for (c = 'a'; c <= 'z'; c++)
            System.out.print(c + "=" + (int) c + " ");
        System.out.println();
        for (c = 'A'; c <= 'Z'; c++)
            System.out.print(c + "=" + (int) c + " ");
        System.out.println();
        for (c = '0'; c <= '9'; c++)
            System.out.print(c + "=" + (int) c + " ");
        System.out.println();

    }
}


