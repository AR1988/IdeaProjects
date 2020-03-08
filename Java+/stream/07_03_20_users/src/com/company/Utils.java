package com.company;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Utils {

    public Map<String, Integer> usersByUrl(Stream<LogEntry> stream) {
        return stream
                .collect(
                        groupingBy(
                                LogEntry::getUrl
                                , mapping(LogEntry::getUsername, collectingAndThen(toSet()
                                        , Set::size)
                                )
                        )
                );
    }

    public Map<String, Map<String, Long>> usersByUrl_UsersList(Stream<LogEntry> stream) {
        return stream
                .collect(
                        groupingBy(
                                LogEntry::getUrl
                                , groupingBy(LogEntry::getUsername
                                        , counting()
                                )
                        )
                );
    }

    public Map<String, Long> linkCliced(Stream<LogEntry> stream) {
        return stream
                .collect(groupingBy(LogEntry::getUrl
                        , counting()
                        )
                );
    }
}
