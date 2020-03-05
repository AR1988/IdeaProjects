package com.company;

public class Transaction {
    private String id;
    private int status;
    private long sum;
    private long created;

    /**
     * @param id      transaction id
     * @param status  -1 canceled, 0 processing, 1 finished
     * @param sum     transaction sum
     * @param created no idea
     */
    public Transaction(String id, int status, long sum, long created) {
        this.id = id;
        this.status = status;
        this.sum = sum;
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public long getSum() {
        return sum;
    }
}
