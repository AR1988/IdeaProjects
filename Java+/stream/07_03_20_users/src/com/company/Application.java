package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        LogEntry logEntry1 = new LogEntry("acc1 ", "ur1 ");
        LogEntry logEntry3 = new LogEntry("acc1 ", "ur1 ");
        LogEntry logEntry4 = new LogEntry("acc1 ", "ur2 ");
        LogEntry logEntry2 = new LogEntry("acc2 ", "ur1 ");
        LogEntry logEntry5 = new LogEntry("acc2 ", "ur1 ");
        LogEntry logEntry6 = new LogEntry("acc2 ", "ur2 ");
        LogEntry logEntry7 = new LogEntry("acc2 ", "ur2 ");
        LogEntry logEntry8 = new LogEntry("acc2 ", "ur1 ");
        LogEntry logEntry9 = new LogEntry("acc3 ", "ur1 ");
        LogEntry logEntry10 = new LogEntry("acc3 ", "ur2 ");
        LogEntry logEntry11 = new LogEntry("acc3 ", "ur3 ");

        List<LogEntry> logEntries = new ArrayList<>(Arrays.asList(logEntry1,
                logEntry2,
                logEntry3,
                logEntry4,
                logEntry5,
                logEntry6,
                logEntry7,
                logEntry8,
                logEntry9,
                logEntry10,
                logEntry11));

        Utils utils = new Utils();
        //группировка по имени url.
        System.out.println(utils.linkClicked(logEntries.stream()).toString());           //количесвто вызовов url
        System.out.println(utils.usersByUrl(logEntries.stream()).toString());           //количесвто уникальных пользователей
        System.out.println(utils.usersByUrl_UsersList(logEntries.stream()).toString()); //список пользователей и из количество
    }
}
