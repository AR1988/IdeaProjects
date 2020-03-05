package com.company;

import java.util.List;

public class Account {
    private String number;
    private long balance;
    private List<Transaction> transactions;

    public Account(String number, List<Transaction> transactions, long balance) {
        this.number = number;
        this.transactions = transactions;
        this.balance = balance + editBalance();
    }

    public long getBalance() {
        return balance;
    }

    private long editBalance() {
        return transactions.stream()
                .filter(tr -> tr.getStatus() == 1)
                .mapToLong(tr -> tr.getSum())
                .sum();
    }

    public long getSumCanceledTransactions() {
        return transactions
                .stream()
                .filter(tr -> tr.getStatus() == -1)
                .mapToLong(Transaction::getSum)
                .sum();
    }
}
