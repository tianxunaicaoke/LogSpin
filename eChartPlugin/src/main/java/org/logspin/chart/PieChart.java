package org.logspin.chart;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.Trigger;
import org.logspin.data.PieData;
import org.logspin.echartplugin.SeriesContainer;

public class PieChart extends BaseChart implements Chart<PieData> {
    @Override
    public Option getChartOption() {
        Option option = getBaseOption();
        option.tooltip().trigger(Trigger.item);
        return option;
    }

    @Override
    public void assembleData(PieData data) {

    }

    @Override
    protected SeriesContainer getSeriesContainer() {
        return new SeriesContainer(ChartType.Pie);
    }
}
