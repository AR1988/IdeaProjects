package com.company;

import java.util.Scanner;

public class Variables {

    public static void main(String[] args) {

//region задача
        int petja = 5;
        int vasja = 5* petja;
        int maria = vasja - 7;

        int all = petja + vasja + maria;
        int ma = maria+ petja;
//endregion
//region вывод
        System.out.println( "\nAre apples: " + all +
                            "\nApples Maria and Petja: " + ma);
//endregion

    }
}
