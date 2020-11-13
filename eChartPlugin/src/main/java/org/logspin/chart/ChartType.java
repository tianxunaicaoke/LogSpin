package org.logspin.chart;

public enum ChartType {
    Non(-1), Line(0), Pie(1);
    private final int index;

    ChartType(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }

}


