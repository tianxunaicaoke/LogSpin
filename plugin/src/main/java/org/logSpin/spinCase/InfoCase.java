package org.logSpin.spinCase;

import org.logSpin.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfoCase extends DefaultCase {

    private final List<Info> list = new ArrayList<>();

    public InfoCase(CaseState caseState) {
        setState(caseState);
    }

    public List<Info> getList() {
        return list;
    }

    public void merge(InfoCase infoCase) {
        list.addAll(infoCase.getList());
    }

    public void addInfo(Info info) {
        list.add(info);
    }

    @Override
    public void action(LogProcess logProcess) {
        searchAndUpdateInfo(logProcess);
        writeToReport(logProcess);
    }

    @Override
    public void applyVariant(List<Variant> variants) {

    }

    private void searchAndUpdateInfo(LogProcess logProcess) {
        List<Request> requests = new ArrayList<>();
        list.forEach(info -> requests.add(new Request(info.getKey())));
        logProcess.invokeMethod("search", requests, (Observable<Response>) response ->
            list.stream()
                    .filter(info -> Objects.equals(info.getKey(), response.getKey()))
                    .findAny()
                    .ifPresent(info -> info.setValue(response.getValue()))
        );
    }

    private void writeToReport(LogProcess logProcess) {
        List<String> infoList = new ArrayList<>();
        list.forEach(info -> {
                    if (info.getValue() != null)
                        infoList.add(info.getDescription()+" : "+info.getValue());
                }
        );
        logProcess.invokeMethod("writeInfo", infoList);
    }

    public static class Builder {
        private CaseState caseState;

        public Builder caseState(CaseState caseState) {
            this.caseState = caseState;
            return this;
        }

        public InfoCase build() {
            return new InfoCase(this.caseState);
        }
    }
}