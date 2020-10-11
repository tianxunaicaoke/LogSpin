package org.logSpin.spinCase;

import groovy.lang.GroovyObjectSupport;
import org.logSpin.DynamicObject;
import org.logSpin.core.AbstractDynamicObject;

import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Rule extends GroovyObjectSupport{
    private HashMap<String, Boolean> when = new HashMap<>();
    private String then;
    private boolean meetWhen;
        private DynamicObject dynamicObject = new AbstractDynamicObject() {
        @Override
        public Object tryInvokeMethod(String name, Object[] params) {
            return super.tryInvokeMethod(name, params);
        }
    };

    public void updateRule(String key, boolean value) {
        when.put(key, value);
    }

    public HashMap<String, Boolean> getWhen() {
        return when;
    }

    public void setWhen(HashMap<String, Boolean> when) {
        this.when = when;
    }

    public Rule when(String[] whens) {
        Arrays.stream(whens)
                .forEach(s -> when.put(s, false));
        return this;
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

    @Override
    public Object invokeMethod(String name, Object args) {
        return dynamicObject.tryInvokeMethod(this, name, (Object[]) args);
    }
}
