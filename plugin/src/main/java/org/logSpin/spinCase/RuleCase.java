package org.logSpin.spinCase;

import org.logSpin.*;

import java.util.ArrayList;
import java.util.List;

public class RuleCase extends DefaultCase {

    private final List<Rule> rules = new ArrayList<>();

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
    public void action(LogProcess logProcess) {
        searchAndUpdateRule(logProcess);
        writeToReport(logProcess);
    }

    private void searchAndUpdateRule(LogProcess logProcess) {
        List<Request> requests = new ArrayList<>();
        rules.forEach(
                rule -> rule.getWhen()
                        .keySet()
                        .forEach(
                                it -> requests.add(new Request(it)))
        );
        logProcess.invokeMethod("findExist", requests, (Observable<Response>) response -> {
            if (response.isExist()) {
                rules.forEach(rule ->
                        rule.getWhen().put(response.getKey(), true)
                );
            }
        });
    }

    private void writeToReport(LogProcess logProcess) {
        List<String> stringList = new ArrayList<>();
        rules.forEach(
                rule ->
                    stringList.add(rule.getThen()+"   "+(rule.isMeetWhen()?"[ok]":"[failure]"))

        );
        logProcess.invokeMethod("writeRule", stringList);
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
