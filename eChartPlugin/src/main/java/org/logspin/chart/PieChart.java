package org.logspin.chart;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.Trigger;
import groovy.lang.Closure;
import org.logspin.data.PieData;
import org.logspin.echartplugin.SeriesContainer;

import java.util.List;

public class PieChart extends BaseChart implements Chart<PieData> {
    @Override
    public Option getChartOption() {
        Option option = getBaseOption();
        option.tooltip().trigger(Trigger.item);
        return option;
    }

    @Override
    public void assembleData(List<PieData> list) {

    }

    @Override
    protected SeriesContainer getSeriesContainer() {
        return new SeriesContainer(ChartType.Pie);
    }
}
