package org.logSpin.spinCase;

import org.logSpin.*;

import java.util.ArrayList;
import java.util.List;

public class RuleCase extends DefaultCase {

    private final List<Rule> rules = new ArrayList<>();
    private final List<Variant> variants = new ArrayList<>();

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
        variants.forEach(
                variant -> {
                    rules.forEach(Rule::resetRule);
                    searchAndUpdateRule(variant, logProcess);
                    writeToReport(variant, logProcess);
                }
        );
    }

    @Override
    public void applyVariant(List<Variant> variants) {
        this.variants.addAll(variants);
    }

    private void searchAndUpdateRule(Variant variant, LogProcess logProcess) {
        List<Request> requests = new ArrayList<>();
        rules.forEach(
                rule -> rule.getWhen()
                        .keySet()
                        .forEach(
                                it -> requests.add(new Request(it, variant.getKey())))
        );
        logProcess.invokeMethod("findExist", requests, (Observable<Response>) response -> {
            if (response.isExist()) {
                rules.forEach(rule ->
                        rule.getWhen().put(response.getKey(), true)
                );
            }
        });
    }

    private void writeToReport(Variant variant, LogProcess logProcess) {
        List<String> stringList = new ArrayList<>();
        stringList.add("==========>  process:"+variant.getName());
        rules.forEach(
                rule ->
                        stringList.add(rule.getThen() + "   " + (rule.isMeetWhen() ? "[ok]" : "[unknown]"))

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
