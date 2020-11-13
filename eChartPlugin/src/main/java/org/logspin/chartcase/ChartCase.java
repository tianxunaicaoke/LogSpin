package org.logspin.chartcase;

import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Series;
import org.logSpin.*;
import org.logSpin.spinCase.DefaultCase;
import org.logspin.chart.Chart;
import org.logspin.data.DataResource;
import org.logspin.data.LineData;
import org.logspin.extendChartForJava.SeriesExtend;

import java.util.ArrayList;
import java.util.List;

public class ChartCase extends DefaultCase {

    private final List<Chart> charts = new ArrayList<>();
    private final List<Variant> variants = new ArrayList<>();

    public void addCharts(List<Chart> charts) {
        this.charts.addAll(charts);
    }

    public List<Chart> getCharts() {
        return charts;
    }

    @Override
    public void action(SpinProcess spinProcess) {
        if (variants.isEmpty()) {
            variants.add(new Variant("", ""));
        }
        variants.forEach(
                variant -> {
                    searchAndUpdateChart(variant, spinProcess);
                    exportToHtml(variant);
                }
        );
    }

    public void merge(ChartCase chartCase) {
        charts.addAll(chartCase.getCharts());
    }

    private void exportToHtml(Variant variant) {
        charts.forEach(
                chart -> ((GsonOption) chart.getChartOption()).exportToHtml("./", variant.getName() + "chartReport.html")
        );
    }

    private void searchAndUpdateChart(Variant variant, SpinProcess spinProcess) {
        List<Request> requests = new ArrayList<>();
        LineData lineData = new LineData();
        charts.forEach(
                chart -> {
                    List<Series> series = chart.getChartOption().getSeries();
                    series.stream()
                            .filter(s -> ((SeriesExtend) s).getDateResource() == DataResource.Log)
                            .forEach(s ->
                                    requests.add(new Request(((SeriesExtend) s).getKey(), variant.getKey()))
                            );
                }
        );
        spinProcess.invokeMethod("findData", requests, (Observable<Response>) response -> lineData.putData(response.getKey(), response.getValue()));
        charts.forEach(
                chart -> chart.assembleData(lineData)
        );
    }
}
