package org.logSpin.spinCase;

import org.logSpin.LogProcess;
import org.logSpin.Rule;

import java.util.ArrayList;
import java.util.List;

public class RuleCase extends DefaultCase {

    private List<Rule> rules = new ArrayList<>();

    public List<Rule> getRules() {
        return rules;
    }

    public void addRules(List<Rule> rules) {
        this.rules.addAll(rules);
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public RuleCase(CaseState state) {
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
