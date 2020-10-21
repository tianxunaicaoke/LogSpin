package org.logSpin.spinCase;

import org.logSpin.*;


import java.util.ArrayList;
import java.util.List;

public class VariantCase extends DefaultCase {

    private final Spin spin;

    private final List<Variant> variants = new ArrayList<>();

    private final List<String> processes = new ArrayList<>();

    public void addProcessId(String processId) {
        processes.add(processId);
    }

    public VariantCase(Spin spin){
        this.spin = spin;
    }

    @Override
    public void action(SpinProcess spinProcess) {
        List<Request> requests = getAndroidProcessRequest();
        spinProcess.invokeMethod("findLine", requests, (Observable<Response>) response -> {
            if (response.getValue() != null && !alreadyContains(response.getValue())) {
                variants.add(new Variant(convertName(response.getKey()),
                        convertValue(response.getValue())));
            }
        });
        writeToReport(spinProcess);
        spin.getLogVariantManager().addVariant(variants);
    }

    private boolean alreadyContains(String s) {
        return variants.stream().anyMatch(variant ->
                variant.getKey().equals(s));
    }

    private void writeToReport(SpinProcess spinProcess) {
        List<String> printString = new ArrayList<>();
        variants.forEach(variant -> {
            String s = variant.getKey() + " : " + variant.getName();
            if (!printString.contains(s)) {
                printString.add(s);
            }
        });
        spinProcess.invokeMethod("writeProcess", printString);
    }

    private List<Request> getAndroidProcessRequest() {
        List<Request> requests = new ArrayList<>();
        AndroidSystemKeyLog.getProcessRelatedKeyLog().forEach(
                key ->
                        processes.forEach(processId ->
                                requests.add(new Request(getRequestKey(key, processId)))
                        )
        );
        return requests;
    }

    private String getRequestKey(String key, String processId) {
        return ".*(" +
                key +
                ")" +
                ".*" +
                processId +
                ",.*";
    }

    private String convertValue(String s) {
        return s.split(",")[1];
    }

    private String convertName(String s) {
        return s.replace(".*", ",")
                .split(",")[2];
    }
}
