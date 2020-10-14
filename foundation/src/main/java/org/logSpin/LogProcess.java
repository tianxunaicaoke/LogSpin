package org.logSpin;


public interface LogProcess {
    void setLogSet(LogSet logSet);

    Object invokeMethod(String name, Object... o);

    Object invokeMethod(String name, Object o);
}
