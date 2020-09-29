package org.logSpin;

public class Request {
    private String key;
    private boolean valued;

    public boolean isValued() {
        return valued;
    }

    public void setValued(boolean valued) {
        this.valued = valued;
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
