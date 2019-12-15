package com.company.randomazer.randomaze_rules;

import com.company.randomazer.RuleRandomInterface;

import java.util.Random;

public class RuleRandomInterfaceRussianRoulette implements RuleRandomInterface {
    private final int AMMO = 6;
    int shotOrder;

    public RuleRandomInterfaceRussianRoulette(int shotOrder) {
        this.shotOrder = shotOrder;
    }

    @Override
    public Object getRandom() {
        Random random = new Random();
        int shot = random.nextInt(AMMO);
        if (shot == shotOrder)
            return "Sorry, y die";
        else
            return "You survived";
    }
}
