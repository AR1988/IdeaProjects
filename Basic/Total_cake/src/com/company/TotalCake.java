package com.company;

public class TotalCake {

    public static void main(String[] args) {

        double mashaPart = 0.3;
        double peterPart = mashaPart / 2;
        double vasjaPart = 4 * (mashaPart + peterPart);

        int totalIntCake = (int) (mashaPart + peterPart + vasjaPart);

        System.out.println(totalIntCake);
    }
}
