package org.logSpin.plugin;

import org.logSpin.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class RuleContainer {

    private final List<Rule> ruleList = new ArrayList<>();

    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void clear() {
        ruleList.clear();
    }

    public Rule when(String[] whens) {
        Rule rule = new Rule();
        Arrays.stream(whens)
                .forEach(s -> rule.getWhen().put(s, false));
        ruleList.add(rule);
        return rule;
    }

    public Rule getMergedRule() {
        if (ruleList.stream().anyMatch(Rule::isLegal)) {
            return null;
        }
        Rule rule = new Rule();
        ruleList.forEach(it -> rule.addWhens(it.getWhen()));
        return rule;
    }
}
