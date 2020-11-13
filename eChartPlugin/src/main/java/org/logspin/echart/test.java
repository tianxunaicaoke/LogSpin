package org.logspin.echart;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;

public class test {
    public static void main(String[] args) {
        a();
    }

    static void a() {

        String[] types = {"sss", "sss", "ss"};
        int[][] datas = {{120, 132, 101, 134, 90, 230, 210}, {220, 182, 191, 234, 290, 330, 310}, {150, 232, 201, 154, 190, 330, 410}};
        String title = "title";

        GsonOption option = new GsonOption();

        option.title().text(title).subtext("fack").x("left");

        option.tooltip().trigger(Trigger.axis);
        option.toolbox().show(true).feature(Tool.saveAsImage);

        option.legend(types);

        CategoryAxis category = new CategoryAxis();
        category.data("s", "s", "s", "s", "s", "s", "s");
        category.boundaryGap(false);

        for (int i = 0; i < types.length; i++) {
            Line line = new Line();
            String type = types[i];
            line.name(type).stack("s");
            for (int j = 0; j < datas[i].length; j++)
                line.data(datas[i][j]);
            option.series(line);
        }

        if (true) {
            option.xAxis(category);
            option.yAxis(new ValueAxis());
        } else {
            option.xAxis(new ValueAxis());
            option.yAxis(category);
        }
       option.exportToHtml("./","aa.html");
    }

}
