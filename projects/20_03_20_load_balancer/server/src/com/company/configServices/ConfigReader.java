package com.company.configServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    String fileDirectory;

    public ConfigReader(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public String loadParamFromConfig(String readParam) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(fileDirectory)));
        return properties.getProperty(readParam);
    }
}