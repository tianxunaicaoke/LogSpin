package org.LogSpin.script;

import org.LogSpin.Spin;

public interface ScriptDelegate {
    void setSpin(Spin spin);
    void apply(String plugin);
    Object invokeMethod(String name, Object[] args);
}
