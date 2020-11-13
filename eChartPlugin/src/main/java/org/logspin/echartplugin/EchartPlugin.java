package org.logspin.echartplugin;

import groovy.lang.Closure;
import org.logSpin.Plugin;
import org.logSpin.Spin;
import org.logSpin.SpinCase;
import org.logSpin.spinCase.DefaultCase;
import org.logspin.chartcase.ChartCase;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unused")
public class EchartPlugin implements Plugin<Spin> {
    private ChartContainer chartContainer;
    private Spin spin;

    @Override
    public void resolveCase(Spin spin) {
        List<SpinCase> cases = spin.getConfiguredCase();
        Iterator<SpinCase> iterator = cases.iterator();
        ChartCase chartCase = new ChartCase();
        while (iterator.hasNext()) {
            SpinCase spinCase = iterator.next();
            if (spinCase instanceof ChartCase) {
                chartCase.merge((ChartCase) spinCase);
            }
        }
        spin.getResolvedCases().add(chartCase);
    }

    @Override
    public void apply(Spin spin) {
        this.spin = spin;
        chartContainer = new ChartContainer();
    }

    public void chart(Closure<?> closure) {
        chartContainer.clear();
        chartContainer.configure(closure, chartContainer);
        ChartCase chartCase = new ChartCase();
        chartCase.addCharts(chartContainer.getList());
        chartCase.setState(DefaultCase.CaseState.Configured);
        spin.getConfiguredCase().add(chartCase);
    }
}
