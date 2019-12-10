package com.company;

public class Censor {

    String[] vocabulary;

    public Censor(String[] vocabulary) {
        this.vocabulary = vocabulary;
    }

    boolean isLegal() {
        String[] isNotLegal = {"is not Legal", "isNotLegal", "unlegal"};

        for (int i = 0; i < vocabulary.length; i++) {
            for (int j = 0; j < isNotLegal.length; j++) {
                if (vocabulary[i].equals(isNotLegal[j]))
                    return false;
            }
        }
        return true;
    }
}
