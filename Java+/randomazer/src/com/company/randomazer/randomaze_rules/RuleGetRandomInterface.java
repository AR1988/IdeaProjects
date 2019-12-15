package com.company.randomazer.randomaze_rules;

import com.company.randomazer.RuleRandomInterface;

import java.util.Arrays;
import java.util.Random;

public class RuleGetRandomInterface implements RuleRandomInterface {
    int quantity;
    int lastNumber;

    public RuleGetRandomInterface(int quantity, int lastNumber) {
        this.quantity = quantity;
        this.lastNumber = lastNumber;
    }

    @Override
    public Object getRandom() {
        Random random = new Random();
        int[] result = new int[quantity];

        for (int i = 0; i < quantity; i++) {
            result[i] = random.nextInt(lastNumber);
        }
        return quantity + " nubers from 0 to " + lastNumber + " are: " + Arrays.toString(result);
    }
}
