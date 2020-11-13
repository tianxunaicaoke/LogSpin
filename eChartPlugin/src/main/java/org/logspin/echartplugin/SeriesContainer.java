package org.logspin.echartplugin;

import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.series.Series;
import groovy.lang.Closure;
import org.logSpin.core.ConfigureUtil;
import org.logSpin.core.NameDomainContainer;
import org.logspin.exception.NoSeriesTypeException;
import org.logspin.chart.ChartType;
import org.logspin.extendChartForJava.ELine;


public class SeriesContainer extends NameDomainContainer<Series> {

    private ChartType chartType;

    public SeriesContainer(ChartType chartType) {
        this.chartType = chartType;
    }

    @Override
    public Series create(String name, Object[] args) {
        Series series = getSeries(chartType);
        series.setName(name);
        add(series);
        if (args[0] instanceof Closure) {
            ConfigureUtil.configureByObject((Closure<?>) args[0], series);
        }
        return series;
    }

    private Series getSeries(ChartType chartType) {
        switch (chartType) {
            case Non:
                throw new NoSeriesTypeException("NoType");
            case Line:
                return new ELine();
            case Pie:
                return new Pie();
        }
        throw new NoSeriesTypeException("NoType");
    }
}
