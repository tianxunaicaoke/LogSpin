package org.logSpin.spinCase;


import org.logSpin.LogProcess;

import java.util.HashMap;

public class InfoCase extends DefaultCase {

    private final HashMap<String, String> list = new HashMap<>();

    private InfoCase(CaseState caseState) {
        setState(caseState);
    }

    public void addInfo(String key, String description) {
        list.put(key,description);
    }

    @Override
    public boolean action(LogProcess logProcess) {
        logProcess.match(list.keySet().toArray(new String[0]));
        return false;
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