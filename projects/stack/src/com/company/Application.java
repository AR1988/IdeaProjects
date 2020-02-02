package com.company;

import com.company.collection.EmptyListException;
import com.company.collection.MaxStack;
import com.company.comparator.OurComparator;
import com.company.comparator.StringComparator;

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

        char ch;
        for (int i = 0; i < 138; i++) {
            ch = (char) i;
            System.out.print(ch + "=" + i + " ");
        }
    }
}


