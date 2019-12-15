package com.company.randomazer.randomaze_rules;

import com.company.randomazer.RuleRandomInterface;

import java.util.Arrays;
import java.util.Random;

public class RuleRandomInterfaceLotto implements RuleRandomInterface {

    int number1;
    int number2;
    int number3;
    int number4;
    int number5;
    int number6;

    public RuleRandomInterfaceLotto(int number1, int number2, int number3, int number4, int number5, int number6) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
    }

    @Override
    public Object getRandom() {
        int[] numbers = new int[6];
        numbers[0] = number1;
        numbers[1] = number2;
        numbers[2] = number3;
        numbers[3] = number4;
        numbers[4] = number5;
        numbers[5] = number6;

        Random random = new Random();
        int[] lotto649 = new int[6];
        for (int i = 0; i < lotto649.length; i++) {
            lotto649[i] = random.nextInt(49);
            System.out.println("win number " + (i + 1) + " :" + lotto649[i]);
        }
        int coincidences = 0; //совпадения
        for (int value : lotto649) {
            for (int number : numbers) {
                if (value == number)
                    coincidences++;
            }
        }

        if (coincidences == 6) {
            return "You Won Jackpot";
        } else {
            return "You lose, coincidences: " + Arrays.toString(lotto649);
        }
    }
}
