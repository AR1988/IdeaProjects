package com.company;

public class Main {

    public static void main(String[] args) {

        int mariaOrded = 4;
        int petjaOrded = mariaOrded / 2;

        int onTable = mariaOrded + petjaOrded;

        int mariaDrank = 1;
        int peterDrank = 1;

        onTable = onTable - peterDrank - mariaDrank;
        int vasjaDrank = onTable +1;

        if (onTable % 3 == 0){
            System.out.println("The beer has been divided");
        } else {
            System.out.println("The beer has not been divided");
        }

        mariaDrank += (onTable / 3);

        if (mariaDrank >  4){
            System.out.println("Maria is funny");
        } else {
            System.out.println("Maria is not funny");
        }
    }
}
