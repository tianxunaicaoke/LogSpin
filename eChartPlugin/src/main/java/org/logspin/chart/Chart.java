package org.logspin.chart;

import com.github.abel533.echarts.Option;

public interface Chart<T> {
    Option getChartOption();

    void assembleData(T data);
}
