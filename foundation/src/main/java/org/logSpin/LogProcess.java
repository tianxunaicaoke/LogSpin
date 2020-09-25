package org.logSpin;


public interface LogProcess {
    void setLogSet(LogSet logSet);
    String[] match(String[] key);
    Object invokeMethod(String name,Object... o);
}
