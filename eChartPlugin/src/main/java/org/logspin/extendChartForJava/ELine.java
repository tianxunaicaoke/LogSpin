package org.logspin.extendChartForJava;

import com.github.abel533.echarts.series.Line;
import org.logspin.data.DataResource;

public class ELine extends Line implements SeriesExtend {

    private DataResource dataResource = DataResource.Spin;
    private String key = null;

    @Override
    public String getKey() {
        return key;
    }

    public void key(String key) {
        this.key = key;
        dataResource = DataResource.Log;
    }

    @Override
    public DataResource getDateResource() {
        return dataResource;
    }
}
