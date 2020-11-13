package org.logspin.extendChartForJava;

import com.github.abel533.echarts.series.Pie;
import org.logspin.data.DataResource;

public class EPie extends Pie implements SeriesExtend {
    @Override
    public String getKey() {
        return null;
    }

    @Override
    public DataResource getDateResource() {
        return null;
    }
}
