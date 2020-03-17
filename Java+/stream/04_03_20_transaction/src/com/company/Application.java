package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        Transaction tr1 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr2 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr3 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr4 = new Transaction(TransactionState.PROCESSING, 10000);
        Transaction tr5 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr6 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr7 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr8 = new Transaction(TransactionState.FINISHED, 10000);
        Transaction tr9 = new Transaction(TransactionState.PROCESSING, 10000);
        Transaction tr10 = new Transaction(TransactionState.CANCELLED, 10000);
        Transaction tr11 = new Transaction(TransactionState.PROCESSING, 10000);
        Transaction tr12 = new Transaction(TransactionState.CANCELLED, 10000);

        Account acc1 = new Account(Arrays.asList(tr1, tr2, tr3, tr4), 1000);
        Account acc2 = new Account(Arrays.asList(tr5, tr6, tr7, tr8), 2000);
        Account acc3 = new Account(Arrays.asList(tr9, tr10, tr11, tr12), 3000);

        Stream<Account> accountStream = Stream.of(acc1, acc2, acc3);
        Utils utils = new Utils();

        System.out.println(utils.sumCanceledTransaktionsWIthPositiveBalance(accountStream));

        Stream<Transaction> transactionStream = Stream.of(tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr9, tr10, tr11, tr2);

        Map<Integer, Long> map = utils.sumAllTransactionsByAccountId(transactionStream);

        System.out.println(map.toString());
    }
}
