package collection;

import java.util.Iterator;
import java.util.Random;

public class OurArrayListRandomIterator<E> implements Iterator<E> {

    private OurArrayList<E> list;

    public OurArrayListRandomIterator(OurArrayList<E> list) {
        this.list = list;
    }

    private int currentEltId;

    @Override
    public boolean hasNext() {
        return currentEltId < list.size();
    }

    @Override
    public E next() {
        Random random = new Random();
        currentEltId++;
        return list.get(random.nextInt(list.size()));
    }
}
