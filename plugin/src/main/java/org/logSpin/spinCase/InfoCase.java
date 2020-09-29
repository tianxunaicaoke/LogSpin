package org.logSpin.spinCase;


import org.logSpin.Info;
import org.logSpin.LogProcess;
import org.logSpin.Request;

import java.util.ArrayList;
import java.util.List;

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
    public boolean action(LogProcess logProcess) {
        List<Request> requests = new ArrayList<>();
        list.forEach( info ->{
            requests.add(new Request(info.getKey()));
        });
        logProcess.invokeMethod("search",requests);
        return true;
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