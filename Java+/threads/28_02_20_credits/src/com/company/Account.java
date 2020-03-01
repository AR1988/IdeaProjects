package com.company;

public class Account {
    private String number;
    private long balance;
    private boolean isLock;

    public Account(String number, long balance, boolean block) {
        this.number = number;
        this.balance = balance;
        this.isLock = block;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isBlock() {
        return isLock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nummer='" + number + '\'' +
                ", balanse=" + balance +
                ", block=" + isLock +
                '}';
    }
}
