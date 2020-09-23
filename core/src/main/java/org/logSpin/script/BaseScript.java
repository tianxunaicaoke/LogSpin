package org.logSpin.script;

import groovy.lang.Script;
import org.logSpin.util.SpinLogLog;

public abstract class BaseScript extends Script {
    private ScriptDelegate scriptDelegate;

    public void init(ScriptDelegate scriptDelegate) {
        this.scriptDelegate = scriptDelegate;
    }

    @SuppressWarnings("unused")
    public void apply(String plugin) {
        SpinLogLog.log("apply: " + plugin);
        scriptDelegate.apply(plugin);
    }

    public Object invokeMethod(String name, Object args) {
        return this.scriptDelegate.invokeMethod(name, (Object[]) args);
    }
}
