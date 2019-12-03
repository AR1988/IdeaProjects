package com.company;

public class Main {

    public static void main(String[] args) {
        resilts(0, 300);
    }
    private static void resilts(int creditNumber, int limit) {
        System.out.format("|%5s|%5s|%5s|%5s|\n", "_____", "_____", "_____", "_____");
        System.out.format("|%5s|%5s|%5s|%5s|\n", "  NR.", "Maria", "Petja", "Vasja");
        System.out.format("|%5s|%5s|%5s|%5s|\n", "_____", "_____", "_____", "_____");

        int creditsAll = 0;
        int creditNumberMaria = 1;
        int creditNumberPetja = 1;
        int creditNumberVasja = 1;

        for (int i = 0; i < limit; i++) {
            creditNumber++;
            if (creditNumber % 13 == 0)
                continue;
            if (creditNumber % 3 == 0)
                System.out.format("|%5s|%5s|%5s|%5s|\n", +creditNumber, creditNumberMaria++, "", "");
            else if (creditNumber % 3 == 1)
                System.out.format("|%5s|%5s|%5s|%5s|\n", +creditNumber, "", creditNumberPetja++, "");
            else
                System.out.format("|%5s|%5s|%5s|%5s|\n", +creditNumber, "", "", creditNumberVasja++);

        }
        System.out.format("|%5s|%5s|%5s|%5s|\n", "_____", "_____", "_____", "_____");
        System.out.println("\nTotal credits checked: " + creditNumber);
        System.out.println("Total credits issued: " + creditsAll);
    }
}







