package org.logSpin.spinCase;


import org.logSpin.LogProcess;

import java.util.ArrayList;
import java.util.HashMap;

public class InfoCase extends DefaultCase {

    private final HashMap<String, String> list = new HashMap<>();

    public InfoCase(CaseState caseState) {
        setState(caseState);
    }

    public HashMap<String, String> getList() {
        return list;
    }

    public void merge(InfoCase infoCase) {
        list.putAll(infoCase.getList());
    }

    public void addInfo(String key, String description) {
        list.put(key,description);
    }

    @Override
    public boolean action(LogProcess logProcess) {
        logProcess.invokeMethod("search",new ArrayList<>(list.keySet()));
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