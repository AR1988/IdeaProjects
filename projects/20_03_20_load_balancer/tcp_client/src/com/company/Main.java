package com.company;

import com.company.configServices.ConfigReader;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final String FILE_DIRECTORY = "config/config.props";

    private static final String OUTER_SERVER_PORT = "OUTER_SERVER_PORT";
    private static final String OUTER_SERVER_IP = "OUTER_SERVER_IP";
    private static final String CLIENT_TASK_NUMBER = "CLIENT_TASK_NUMBER";

    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader(FILE_DIRECTORY);
        String outerServerIP = configReader.loadParamFromConfig(OUTER_SERVER_IP);
        int outerServerPort = Integer.parseInt(configReader.loadParamFromConfig(OUTER_SERVER_PORT));
        int taskNumber = Integer.parseInt(configReader.loadParamFromConfig(CLIENT_TASK_NUMBER));

        ExecutorService executor = Executors.newFixedThreadPool(taskNumber);

        for (int i = 0; i <= taskNumber; i++) {
            Runnable taskToServer = new MyTask(outerServerIP, outerServerPort, "\tline nr: " + i);
            executor.execute(taskToServer);
        }
        executor.shutdown();
    }
}

