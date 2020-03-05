package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Transaction> transactionList1 = new ArrayList<>(Arrays.asList(
                new Transaction("0", -1, 1000, 1),
                new Transaction("2", 0, 1000, 1),
                new Transaction("3", 0, 1000, 1),
                new Transaction("4", 0, 1000, 1),
                new Transaction("5", -1, 1000, 1))); //2_000

        List<Transaction> transactionList2 = new ArrayList<>(Arrays.asList(
                new Transaction("0", -1, 1000, 1),
                new Transaction("2", -1, 1000, 1),
                new Transaction("3", -1, 1000, 1),
                new Transaction("4", -1, 1000, 1),
                new Transaction("5", -1, 1000, 1))); //5_000

        List<Transaction> transactionList3 = new ArrayList<>(Arrays.asList(
                new Transaction("0", -1, 1000, 1),
                new Transaction("2", 1, 1000, 1),
                new Transaction("3", 1, 1000, 1),
                new Transaction("4", 1, 5000, 1),
                new Transaction("5", 1, 5000, 1)));//1000

        List<Transaction> transactionList4 = new ArrayList<>(Arrays.asList(
                new Transaction("0", -1, 1000, 1),
                new Transaction("2", 1, 1000, 1),
                new Transaction("3", 1, 1000, 1),
                new Transaction("4", 0, 1000, 1),
                new Transaction("5", -1, 500, 1)));//1_500

        List<Transaction> transactionList5 = new ArrayList<>(Arrays.asList(
                new Transaction("0", -1, 1050, 1),
                new Transaction("2", 0, 1000, 1),
                new Transaction("3", -1, 1000, 1),
                new Transaction("4", 0, 1000, 1),
                new Transaction("5", -1, 1750, 1)));//3_800

        List<Account> accountList = new ArrayList<>(Arrays.asList(
                new Account("1", transactionList1, 0),          //2000 //0          -
                new Account("2", transactionList2, 4000),       //5000  //4000 +
                new Account("3", transactionList3, -10_000),    //1000 //2000  +
                new Account("3", transactionList4, 0),          //1500 //2000  +
                new Account("4", transactionList5, 0)));        //3800 //0          -


        long res = accountList.stream()
                .filter(acc -> acc.getBalance() > 0)
                .mapToLong(Account::getSumCanceledTransactions)
                .sum();
        System.out.println(res);
        for (Account acc : accountList)
            System.out.println(acc.getBalance());
    }
}
