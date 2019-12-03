package com.company;

import java.util.Scanner;

public class converterNum {

            public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);

                while (true) {
                    System.out.println("");
                    System.out.println("Enter number:");
                    int convertNumberTen = scan.nextInt();
                    int x = convertNumberTen / 1;

                    for (int resultLog = (int) (Math.log(x) / Math.log(2)); resultLog != -1; resultLog--) {
                        int resultTwo = (int) (convertNumberTen / Math.pow(2, resultLog) % 2);
                        System.out.print(resultTwo);
                    }

// region old code
//            System.out.println(" ");
//            System.out.println("exit = < q >, reply < any key >");
//            String finish = scan.next();
//            if (finish.equals("q")) {
//                break;
//            }
//        }

//        for (int steps = 0; convert_number_ten / (Math.pow(2, steps)) > 1; steps++) {
//            System.out.println(steps);
//            int result_two = (int) (convert_number_ten / Math.pow(2, steps) % 2);
//            System.out.print(result_two);
//endregion
                }
            }
        }



