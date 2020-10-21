package org.logSpin.spinCase;

import org.logSpin.Flow;
import org.logSpin.SpinProcess;
import org.logSpin.Variant;

import java.util.ArrayList;
import java.util.List;

public class FlowCase extends DefaultCase{

    private final List<Flow> flows = new ArrayList<>();
    private final List<Variant> variants = new ArrayList<>();

    public void addFlows(List<Flow> flows){
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
        stringList.add("==========>  process:" + variant.getKey());
        flows.stream().flatMap(flow ->
                flow.getKeys().stream().map(it-> flow.getName()+it)
        ).forEach(stringList::add);
        spinProcess.invokeMethod("writeRule", stringList);
    }

    private void searchAndUpdateFlow(Variant variant, SpinProcess spinProcess) {

    }

    @Override
    public void applyVariant(List<Variant> variants) {
        this.variants.addAll(variants);
    }
}
