package org.logSpin;

public class Request {

    private String variant;
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

    public Request(String key, String variant) {
        this.key = key;
        this.variant = variant;
    }

    public void key(String key) {
        this.key = key;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
