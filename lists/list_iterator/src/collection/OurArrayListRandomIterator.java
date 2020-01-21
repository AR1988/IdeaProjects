package collection;

import java.util.*;

public class OurArrayListRandomIterator<E> implements Iterator<E> {

    private List<E> cached;
    private int currentId;

    public OurArrayListRandomIterator(OurArrayList<E> list) {
        cached = new ArrayList<>();
        for (E elements : list) {
            cached.add(elements);
        }
        Collections.shuffle(cached);
    }

    @Override
    public boolean hasNext() {
        return currentId < cached.size();
    }

    @Override
    public E next() {
        return cached.get(currentId++);
    }
}
