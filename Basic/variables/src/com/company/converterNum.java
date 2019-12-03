package com.company;

import java.util.Scanner;

public class converterNum {

    public static void main(String[] args) {

    Scanner scan  = new Scanner(System.in);

     while (true) {
         System.out.println("");
         System.out.println("Enter number:");
        int convert_number_ten = scan.nextInt(); //number
        int x = convert_number_ten / 1;

    for (int result_log = (int) (Math.log(x) / Math.log(2)); result_log != -1; result_log--) {
        int result_two = (int) (convert_number_ten / Math.pow(2, result_log) % 2);
        System.out.print(result_two);
        }



/*        System.out.println(" "); System.out.println("exit = < q >, reply < any key >");
        String finish = scan.next();
        if (finish.equals("q")) {break;}*/
}
        //region from 10 to 2
/*    for (int steps = 0; convert_number_ten / (Math.pow(2, steps)) > 1; steps++)
    {       System.out.println(steps);
            int result_two = (int) (convert_number_ten / Math.pow(2, steps)%2);
            System.out.print(result_two);
        }*/
        //endregion
    }
}