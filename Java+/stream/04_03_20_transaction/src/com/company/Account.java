package com.company;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private static AtomicInteger incrementer = new AtomicInteger();
    private int id;
    private long balance;
    private List<Transaction> transactions;

    public Account(List<Transaction> transactions, long balance) {
        id = incrementer.incrementAndGet();
        this.transactions = transactions;
        this.balance = balance + editBalance();

        transactions.forEach(tr -> tr.setId(id));
    }

    public long getBalance() {
        return balance;
    }


    private long editBalance() {
        return transactions.stream()
                .filter(tr -> tr.getState() == TransactionState.FINISHED)
//                .mapToLong(tr -> tr.getSum())
                .mapToLong(Transaction::getSum)
                .sum();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
