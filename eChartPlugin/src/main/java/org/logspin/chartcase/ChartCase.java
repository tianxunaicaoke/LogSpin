package org.logspin.chartcase;

import com.github.abel533.echarts.json.GsonOption;
import org.logSpin.SpinProcess;
import org.logSpin.Variant;
import org.logSpin.spinCase.DefaultCase;
import org.logspin.chart.Chart;

import java.util.ArrayList;
import java.util.List;

public class ChartCase extends DefaultCase {

    private final List<Chart> charts = new ArrayList<>();
    private final List<Variant> variants = new ArrayList<>();

    public void addCharts(List<Chart> charts){
        this.charts.addAll(charts);
    }

    public List<Chart> getCharts() {
        return charts;
    }

    @Override
    public void action(SpinProcess spinProcess) {
        if(variants.isEmpty()){
            variants.add(new Variant("",""));
        }
        variants.forEach(
                variant -> {
                    searchAndUpdateChart(variant, spinProcess);
                    writeToReport(variant, spinProcess);
                }
        );
    }

    public void merge(ChartCase chartCase){
        charts.addAll(chartCase.getCharts());
    }

    private void writeToReport(Variant variant, SpinProcess spinProcess) {
      charts.forEach(
              chart -> ((GsonOption)chart.getChartOption()).exportToHtml("./","chartReport.html")
      );
    }

    private void searchAndUpdateChart(Variant variant, SpinProcess spinProcess) {
        charts.forEach(
                chart -> chart.assembleData(new ArrayList())
        );
    }
}
