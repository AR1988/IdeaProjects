package com.company;

import com.company.randomazer.*;
import com.company.randomazer.randomaze_rules.RuleGetRandomInterface;
import com.company.randomazer.randomaze_rules.RuleRandomInterfaceLotto;
import com.company.randomazer.randomaze_rules.RuleRandomInterfaceMinMax;
import com.company.randomazer.randomaze_rules.RuleRandomInterfaceRussianRoulette;

public class Main {

    public static void main(String[] args) {
        // написать класс Randomizer, который содержит метод next().
        // Метод next() отдает рандомные числа по определенуму правилу (Interface RandomRule, Class Rule_###)


        RuleRandomInterface ruleMinMax = new RuleRandomInterfaceMinMax(55, 58);
        RuleRandomInterface ruleLotto = new RuleRandomInterfaceLotto(0, 2, 5, 10, 15, 22);
        RuleRandomInterface ruleRussianRoulette = new RuleRandomInterfaceRussianRoulette(2);
        RuleRandomInterface ruleGetRandom = new RuleGetRandomInterface(5,200);

        Randomize fromTo = new Randomize(ruleMinMax);
        Randomize lotto = new Randomize(ruleLotto);
        Randomize russianRoulette = new Randomize(ruleRussianRoulette);
        Randomize getRandom = new Randomize(ruleGetRandom);

        System.out.println(fromTo.next());
        System.out.println(lotto.next());
        System.out.println(russianRoulette.next());
        System.out.println(getRandom.next());
    }
}
