package org.logSpin;


public interface SpinProcess {
    void setLogSet(LogSet logSet);
    void addTheObserver(Observable<String> observable);

    Object invokeMethod(String name, Object... o);

    Object invokeMethod(String name, Object o);
}
