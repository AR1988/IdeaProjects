package com.company;

import java.util.function.Predicate;

public class TerraryPredicate<T> implements ITerraryPredicate {
    @Override
    public boolean test(Object a, Object b, Object c) {
        boolean ab = a != b;
        boolean bc = a != c;
        boolean ac = a != c;

        return ab && bc && ac;
    }
}
