package org.logSpin;

import java.util.Arrays;

public class LogSet {

    private String[] LogPath = {System.getProperty("user.dir")};

    public String[] getLogPath() {
        return LogPath;
    }

    public void setLogPath(String[] logPath) {
        LogPath = logPath;
    }

    @Override
    public String toString() {
        return "LogSet{" +
                "LogPath=" + Arrays.toString(LogPath) +
                '}';
    }
}
