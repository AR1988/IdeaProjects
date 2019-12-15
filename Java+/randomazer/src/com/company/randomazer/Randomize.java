package com.company.randomazer;


import com.company.randomazer.RuleRandomInterface;

public class Randomize {
    private RuleRandomInterface rule;

    public Randomize(RuleRandomInterface rule) {
        this.rule = rule;
    }

    public Object next() {
        System.out.println();
        return rule.getRandom();
    }
}
