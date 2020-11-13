package org.logspin.chart;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import org.logspin.data.LineData;
import org.logspin.echartplugin.SeriesContainer;
import org.logspin.extendChartForJava.ECategoryAxis;
import org.logspin.extendChartForJava.SeriesExtend;

import java.util.List;
import java.util.stream.IntStream;


@SuppressWarnings("unused")
public class LineChart extends BaseChart implements Chart<LineData> {
    private int maxX = 0;

    @Override
    public Option getChartOption() {
        Option option = getBaseOption();
        option.tooltip().trigger(Trigger.axis);
        option.yAxis(new ValueAxis());
        return option;
    }

    public void x(Object... data) {
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.data(data);
        getBaseOption().xAxis(categoryAxis);
    }

    public void y(Object... data) {

    }

    @Override
    public void assembleData(LineData data) {
        getBaseOption().getSeries().forEach(
                series -> {
                    String key = ((SeriesExtend) series).getKey();
                    List<String> values = data.getData(key);
                    if (values != null) {
                        series.data(values.toArray());
                        if (maxX < values.size()) {
                            maxX = values.size();
                        }
                    }
                }
        );

        ECategoryAxis categoryAxis = new ECategoryAxis();
        categoryAxis.data(IntStream.range(0,maxX).toArray());
        getBaseOption().xAxis(categoryAxis);
    }

    @Override
    protected SeriesContainer getSeriesContainer() {
        return new SeriesContainer(ChartType.Line);
    }
}
