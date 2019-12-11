package com.company;

public class Censor {

     String[] vocabulary;

    public Censor(String[] vocabulary) {

        this.vocabulary = vocabulary;
    }

    boolean isLegal(String text) {
        for (int i = 0; i < vocabulary.length; i++) {
            if (text.contains(vocabulary[i])) return false;
        }
        return true;
    }
}
