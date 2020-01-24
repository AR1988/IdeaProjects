package com.company;

import com.company.action.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        TextAction reverseAction = new ReverseAction("WarPeace.txt", "reversed.txt");
        TextAction toUpperCaseAction = new ToUpperCaseAction("WarPeace.txt", "upper.txt");
        TextAction sortAction = new SortAction("WarPeace.txt", "sort.txt");

        reverseAction.perform();
        toUpperCaseAction.perform();
        sortAction.perform();
    }
}
