package com.company;

import java.util.Scanner;

public class SenderThread extends Thread {

    Messenger messenger;

    public SenderThread(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null && !line.equals("q")) {
            try {
                messenger.addMessage(line);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
