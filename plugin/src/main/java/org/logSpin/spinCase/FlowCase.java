package org.logSpin.spinCase;

import org.logSpin.*;

import java.util.ArrayList;
import java.util.List;

public class FlowCase extends DefaultCase {

    private final List<Flow> flows = new ArrayList<>();
    private final List<Variant> variants = new ArrayList<>();

    public void addFlows(List<Flow> flows) {
        this.flows.addAll(flows);
    }

    public List<Flow> getFlows() {
        return flows;
    }

    public void merge(FlowCase flowCase) {
        flows.addAll(flowCase.getFlows());
    }

    @Override
    public void action(SpinProcess spinProcess) {
        variants.forEach(
                variant -> {
                    flows.forEach(Flow::reset);
                    searchAndUpdateFlow(variant, spinProcess);
                    writeToReport(variant, spinProcess);
                }
        );
    }

    private void writeToReport(Variant variant, SpinProcess spinProcess) {
        List<String> stringList = new ArrayList<>();
        if (flows.stream().allMatch(flow -> flow.getFlowValue().size() == 0)) {
            return;
        }
        stringList.add("==========>  process:" + variant.getKey());
        flows.forEach(
                flow -> {
                    stringList.add("[ " + flow.getName() + " ]  {");
                    stringList.addAll(flow.getFlowValue());
                    stringList.add("}");
                }
        );
        spinProcess.invokeMethod("writeRule", stringList);
    }

    private void searchAndUpdateFlow(Variant variant, SpinProcess spinProcess) {
        List<Request> requests = new ArrayList<>();
        flows.forEach(
                flow -> flow.getKeys()
                        .forEach(
                                it -> requests.add(new Request(it, variant.getKey())))
        );

        spinProcess.invokeMethod("findFlow", requests, (Observable<Response>) response -> {
            if (response.getValue() != null) {
                flows.forEach(it -> {
                            if (it.getKeys().contains(response.getKey()))
                                it.addFlowValue(response.getValue());
                        }
                );
            }
        });
    }

    @Override
    public void applyVariant(List<Variant> variants) {
        this.variants.addAll(variants);
    }
}
