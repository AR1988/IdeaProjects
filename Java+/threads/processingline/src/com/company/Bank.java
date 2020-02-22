package com.company;

import java.util.Deque;

/**
 * data source for results
 */
public class Bank {
    private final Deque<String> deque;

    public Bank(Deque<String> deque) {
        this.deque = deque;
    }

    /**
     *
     * @param line append new result line to data source
     */
    public void add(String line) {
        deque.add(line);
    }

    /**
     *
     * @return first elt in date source and remove it
     */
    public String get() {
        return deque.pollFirst();
    }

    /**
     * @return size of data source
     */
    public int size() {
        return deque.size();
    }
}
