package org.logSpin;

import java.util.Arrays;

@SuppressWarnings("unused")
public class LogSet {

    private String[] logPath = {System.getProperty("user.dir")};

    public String[] getLogPath() {
        return logPath;
    }

    public void setLogPath(String[] logPath) {
        this.logPath = logPath;
    }

    @Override
    public String toString() {
        return "LogSet{" +
                "LogPath=" + Arrays.toString(logPath) +
                '}';
    }
}
