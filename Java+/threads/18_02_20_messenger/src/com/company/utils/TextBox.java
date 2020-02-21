package com.company.utils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TextBox {
    Queue<String> source = new ConcurrentLinkedQueue<>();

    public String getElt() throws InterruptedException {
        return source.remove();
    }

    public void addElt(String elt) {
        source.add(elt);
    }
}
