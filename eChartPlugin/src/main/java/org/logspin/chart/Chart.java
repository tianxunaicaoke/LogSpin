package org.logspin.chart;

import com.github.abel533.echarts.Option;

import java.util.List;

public interface Chart<T> {
    Option getChartOption();
    void assembleData(List<T> list);
}
