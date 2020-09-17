package org.LogSpin.script;

import groovy.lang.Script;

public abstract class BaseScript extends Script {
    ScriptDelegate scriptDelegate;
    public void init(ScriptDelegate scriptDelegate){
     this.scriptDelegate = scriptDelegate;
    }

    public void apply(String plugin){
        System.out.println("apply: "+plugin);
        scriptDelegate.apply(plugin);
    }

    public Object invokeMethod(String name, Object args) {
        return this.scriptDelegate.invokeMethod(name, (Object[])args);
    }
}
