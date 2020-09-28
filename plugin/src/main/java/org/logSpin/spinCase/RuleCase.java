package org.logSpin.spinCase;

import org.logSpin.LogProcess;

public class RuleCase extends DefaultCase{

    public RuleCase(CaseState state){
        setState(state);
    }

    @Override
    public boolean action(LogProcess logProcess) {
        return false;
    }

    public static class Builder {
        private CaseState caseState;

        public Builder caseState(CaseState caseState) {
            this.caseState = caseState;
            return this;
        }

        public RuleCase build() {
            return new RuleCase(this.caseState);
        }
    }
}
