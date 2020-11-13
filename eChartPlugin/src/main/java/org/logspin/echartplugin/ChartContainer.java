package org.logspin.echartplugin;

import groovy.lang.Closure;
import org.logSpin.core.ConfigureUtil;
import org.logSpin.core.NameDomainContainer;
import org.logspin.chart.BaseChart;
import org.logspin.chart.Chart;
import org.logspin.chart.ChartFactory;

public class ChartContainer extends NameDomainContainer<Chart> {

    private final ChartFactory chartFactory = new ChartFactory();

    @Override
    public Chart create(String name, Object[] args) {
        String type = (String) args[0];
        Chart chart = chartFactory.findChartByType(type);
        ((BaseChart) chart).setName(name);
        add(chart);
        if (args[1] instanceof Closure) {
            ConfigureUtil.configureByObject((Closure<?>) args[1], chart);
        }
        return chart;
    }
}
