package org.logSpin.process;

import java.util.List;

@SuppressWarnings("unused")
public class SearchBean {

    private String[] path;
    private List<String> keys;

    public SearchBean(String[] path, List<String> keys) {
        this.path = path;
        this.keys = keys;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
}
