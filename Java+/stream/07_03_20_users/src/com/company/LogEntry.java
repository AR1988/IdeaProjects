package com.company;

public class LogEntry {
    private String username;
    private String url;

    public LogEntry(String username, String url) {
        this.username = username;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }
}
