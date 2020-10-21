package org.logSpin.spinCase;

import org.logSpin.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfoCase extends DefaultCase {

    private final List<Info> list = new ArrayList<>();

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
    public void action(SpinProcess spinProcess) {
        searchAndUpdateInfo(spinProcess);
        writeToReport(spinProcess);
    }

    private void searchAndUpdateInfo(SpinProcess spinProcess) {
        List<Request> requests = new ArrayList<>();
        list.forEach(info -> requests.add(new Request(info.getKey())));
        spinProcess.invokeMethod("search", requests, (Observable<Response>) response ->
            list.stream()
                    .filter(info -> Objects.equals(info.getKey(), response.getKey()))
                    .findAny()
                    .ifPresent(info -> info.setValue(response.getValue()))
        );
    }

    private void writeToReport(SpinProcess spinProcess) {
        List<String> infoList = new ArrayList<>();
        list.forEach(info -> {
                    if (info.getValue() != null)
                        infoList.add(info.getDescription()+" : "+info.getValue());
                }
        );
        spinProcess.invokeMethod("writeInfo", infoList);
    }
}