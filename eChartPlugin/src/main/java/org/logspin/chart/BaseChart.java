package org.logspin.chart;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.json.GsonOption;
import groovy.lang.Closure;
import org.logspin.echartplugin.SeriesContainer;

/**
 * This class is the root of chart
 */
@SuppressWarnings("unused")
public abstract class BaseChart {
    protected String name;
    private final GsonOption option = new GsonOption();

    public void setName(String name) {
        this.name = name;
    }

    protected Option getBaseOption() {
        option.toolbox()
                .show(true)
                .feature(Tool.saveAsImage)
                .feature(Tool.dataZoom);
        return option;
    }

    public void legend(Object... names) {
        option.legend(names);
    }

    public void title(String title) {
        option.title(title);
    }

    protected abstract SeriesContainer getSeriesContainer();

    public SeriesContainer series(Closure<?> closure) {
        SeriesContainer seriesContainer = getSeriesContainer();
        seriesContainer.configure(closure, seriesContainer);
        seriesContainer.getList().forEach(
                s -> option.series(s));
        return seriesContainer;
    }
}
