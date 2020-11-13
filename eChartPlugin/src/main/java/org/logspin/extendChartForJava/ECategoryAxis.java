package org.logspin.extendChartForJava;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.code.AxisType;

import java.util.ArrayList;
import java.util.Arrays;

public class ECategoryAxis extends CategoryAxis {

    public CategoryAxis data(Object... values) {
        if (values == null || values.length == 0) {
            return this;
        }
        if (this.data == null) {
            if (this.getType() == AxisType.category) {
                data = new ArrayList<>();
            } else {
                throw new RuntimeException("Axis error!");
            }
        }
        int[] v = (int[]) values[0];
        if (values.length == 1) {
            for (int vv : v) {
                this.data.add(vv);
            }
        } else {
            this.data.addAll(Arrays.asList(values));
        }
        return this;
    }
}
