package com.company;

import java.util.function.Function;

public class OldSchool implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer * 2;
    }
}
