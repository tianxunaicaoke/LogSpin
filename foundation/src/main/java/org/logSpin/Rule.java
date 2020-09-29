package org.logSpin;

import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Rule {
    private HashMap<String, Boolean> when = new HashMap<>();
    private String then;
    private boolean meetWhen;

    public void updateRule(String key, boolean value) {
        when.put(key, value);
    }

    public HashMap<String, Boolean> getWhen() {
        return when;
    }

    public void setWhen(HashMap<String, Boolean> when) {
        this.when = when;
    }

    public void when(String[] whens) {
        Arrays.stream(whens)
                .forEach(s -> when.put(s, false));
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
        return meetWhen;
    }

    public void setMeetWhen(boolean meetWhen) {
        this.meetWhen = meetWhen;
    }
}
