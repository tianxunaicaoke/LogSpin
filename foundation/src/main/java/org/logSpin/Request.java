package org.logSpin;

public class Request {
    private String key;
    private boolean alreadyFound;

    public boolean isAlreadyFound() {
        return alreadyFound;
    }

    public void setAlreadyFound(boolean alreadyFound) {
        this.alreadyFound = alreadyFound;
    }

    public String getKey() {
        return key;
    }

    public Request(String key) {
        this.key = key;
    }

    public void key(String key) {
        this.key = key;
    }
}
