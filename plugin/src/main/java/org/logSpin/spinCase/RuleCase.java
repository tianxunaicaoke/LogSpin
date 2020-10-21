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

    @Override
    public void action(SpinProcess spinProcess) {
        variants.forEach(
                variant -> {
                    rules.forEach(Rule::resetRule);
                    searchAndUpdateRule(variant, spinProcess);
                    writeToReport(variant, spinProcess);
                }
        );
    }

    @Override
    public void applyVariant(List<Variant> variants) {
        this.variants.addAll(variants);
    }

    private void searchAndUpdateRule(Variant variant, SpinProcess spinProcess) {
        List<Request> requests = new ArrayList<>();
        rules.forEach(
                rule -> rule.getWhen()
                        .keySet()
                        .forEach(
                                it -> requests.add(new Request(it, variant.getKey())))
        );
        spinProcess.invokeMethod("findExist", requests, (Observable<Response>) response -> {
            if (response.isExist()) {
                rules.forEach(rule ->
                        rule.getWhen().put(response.getKey(), true)
                );
            }
        });
    }

    private void writeToReport(Variant variant, SpinProcess spinProcess) {
        List<String> stringList = new ArrayList<>();
        if (rules.stream().anyMatch(Rule::isMeetWhen)) {
            stringList.add("==========>  process:" + variant.getKey());
            rules.forEach(
                    rule ->
                            stringList.add(rule.getThen() + "   " + (rule.isMeetWhen() ? "[ok]" : "[unknown]"))

            );
            spinProcess.invokeMethod("writeRule", stringList);
        }
    }

}
