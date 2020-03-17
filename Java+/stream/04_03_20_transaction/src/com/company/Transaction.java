package com.company;

public class Transaction {
    private static int incrementer;

    private int id;
    private TransactionState state;
    private long sum;
    private int accId;

    public Transaction(TransactionState state, long sum) {
        synchronized (Transaction.class) {
            id = ++incrementer;
        }
        this.state = state;
        this.sum = sum;
    }


    public void setId(int accIDFromAccount) {
        this.accId = accIDFromAccount;
    }

    public int getAccId() {
        return accId;
    }

    public TransactionState getState() {
        return state;
    }

    public  long getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", state=" + state +
                ", sum=" + sum +
                ", accId=" + accId +
                '}';
    }
}

enum TransactionState {
    CANCELLED, FINISHED, PROCESSING
}
