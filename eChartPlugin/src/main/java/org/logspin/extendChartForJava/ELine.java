package org.logspin.extendChartForJava;

import com.github.abel533.echarts.series.Line;
import org.logspin.data.DataResource;

public class ELine extends Line implements SeriesExtend {

    private DataResource dataResource = DataResource.Spin;
    private String str = null;


    public String getStr() {
        return str;
    }

    public void data(String key) {
        str = key;
        dataResource = DataResource.Log;
    }

    @Override
    public DataResource getDateResource() {
        return dataResource;
    }
}
