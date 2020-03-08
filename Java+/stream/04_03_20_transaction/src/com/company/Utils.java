package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.util.stream.Collectors.*;

public class Utils {
    /**
     * @param stream stream account
     * @return summing of canceled Transactions with positive Balsnce
     */
    public long sumCanceledTransaktionsWIthPositiveBalance(Stream<Account> stream) {
        return stream
                .filter(acc -> acc.getBalance() > 0)
                .flatMap(acc -> acc.getTransactions().stream())
                .filter(tr -> tr.getState() == TransactionState.CANCELLED)
//                .mapToLong(tr -> tr.getSum())
                .mapToLong(Transaction::getSum)
                .sum();
    }

    /**
     * @param stream transaction stream/streams
     * @return grouping map by AccountId
     */
    public Map<Integer, Long> sumAllTransactionsByAccountId(Stream<Transaction> stream) {
        return stream
                .collect(
                        Collectors.groupingBy(Transaction::getAccId, Collectors.summingLong(Transaction::getSum)));
    }
}

