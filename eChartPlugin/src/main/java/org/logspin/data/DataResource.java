package org.logspin.data;

public enum  DataResource {
    Spin(-1), Log(0), File(1);
    private final int index;

    DataResource(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }

}