package org.logspin.chart;


public class ChartFactory {
    public static final String TYPE_PIE = "Pie";
    public static final String TYPE_LINE = "Line";

    public Chart findChartByType(String type) {
        if (type.equals(TYPE_PIE)) {
            return new PieChart();
        } else if (type.equals(TYPE_LINE)) {
            return new LineChart();
        }

        return new LineChart();
    }
}
