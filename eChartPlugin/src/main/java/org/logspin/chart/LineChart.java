package org.logspin.chart;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import org.logspin.data.LineData;
import org.logspin.echartplugin.SeriesContainer;
import org.logspin.extendChartForJava.ECategoryAxis;

import java.util.List;
import java.util.stream.IntStream;

public class LineChart extends BaseChart implements Chart<LineData> {
    @Override
    public Option getChartOption() {
        Option option = getBaseOption();
        option.tooltip().trigger(Trigger.axis);
        option.yAxis(new ValueAxis());
        return option;
    }

    @Override
    public void assembleData(List<LineData> list) {
        ECategoryAxis categoryAxis = new ECategoryAxis();
        getBaseOption().getSeries()
                .stream()
                .findFirst()
                .ifPresent(
                        s -> categoryAxis.data(IntStream.range(0,s.data().size()).toArray()));
        getBaseOption().xAxis(categoryAxis);
    }

    @Override
    protected SeriesContainer getSeriesContainer() {
        return new SeriesContainer(ChartType.Line);
    }
}
