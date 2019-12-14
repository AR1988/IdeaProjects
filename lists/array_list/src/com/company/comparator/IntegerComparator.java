package com.company.comparator;


public class IntegerComparator<E> extends AbstractComparator<E> {


    @Override
    public int compare(E o1, E o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;

//        if (i1 < i2)
//            return -1;
//        else if (i1 > i2)
//            return 1;
        return i1 - i2;
    }
}
