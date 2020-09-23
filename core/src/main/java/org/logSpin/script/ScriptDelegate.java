package org.logSpin.script;

import org.logSpin.Spin;

public interface ScriptDelegate {
    void setSpin(Spin spin);
    void apply(String plugin);
    Object invokeMethod(String name, Object[] args);
}
