package org.logspin.echartplugin;

import com.github.abel533.echarts.series.Series;
import groovy.lang.Closure;
import org.logSpin.core.ConfigureUtil;
import org.logSpin.core.NameDomainContainer;
import org.logspin.exception.NoSeriesTypeException;
import org.logspin.chart.ChartType;
import org.logspin.extendChartForJava.ELine;
import org.logspin.extendChartForJava.EPie;
import org.logspin.extendChartForJava.SeriesExtend;


public class SeriesContainer extends NameDomainContainer<SeriesExtend> {

    private final ChartType chartType;

    public SeriesContainer(ChartType chartType) {
        this.chartType = chartType;
    }

    @Override
    public SeriesExtend create(String name, Object[] args) {
        SeriesExtend series = getSeries(chartType);
        ((Series)series).setName(name);
        add(series);
        if (args[0] instanceof Closure) {
            ConfigureUtil.configureByObject((Closure<?>) args[0], series);
        }
        return series;
    }

    private SeriesExtend getSeries(ChartType chartType) {
        switch (chartType) {
            case Non:
                throw new NoSeriesTypeException("NoType");
            case Line:
                return new ELine();
            case Pie:
                return new EPie();
        }
        throw new NoSeriesTypeException("NoType");
    }
}
