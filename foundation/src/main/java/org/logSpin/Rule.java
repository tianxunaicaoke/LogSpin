package org.logSpin;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Rule {
    private HashMap<String, Boolean> when = new HashMap<>();
    private String then;

    public void updateRule(String key, boolean value) {
        when.put(key, value);
    }

    public void addWhens(HashMap<String, Boolean> whens) {
        when.putAll(whens);
    }

    public HashMap<String, Boolean> getWhen() {
        return when;
    }

    public void setWhen(HashMap<String, Boolean> when) {
        this.when = when;
    }

    public void then(String then) {
        this.then = then;
    }

    public String getThen() {
        return then;
    }

    public void setThen(String then) {
        this.then = then;
    }

    public boolean isMeetWhen() {
        return when.values().stream().allMatch(it-> it);
    }

    public boolean isLegal() {
        return !when.isEmpty() && then != null;
    }
}
