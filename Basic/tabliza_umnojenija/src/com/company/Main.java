package com.company;

public class Main {

    public static void main(String[] args) {

        int maria = getSum(50,18,1);
        int petja = getSum(40,18/2,1);
        int vasjaFirst10Months = getSum(50,10,-1);
        int vasjaOtherMonths = getSum(50,8,1);

        int creditsTogether = maria + petja + vasjaFirst10Months + vasjaOtherMonths;
        System.out.println(creditsTogether);
    }

    static int getSum (int credits, int months, int step){
        int sum = 0;
        for (int i = 1; i <= months; i++) {
            sum += credits;
            credits += step;
        }
        return sum;
    }
}



