package org.logSpin;

public interface DynamicObject {
    Object tryInvokeMethod(Object clazz,String name, Object[] params);
    Object tryInvokeMethod(String name, Object[] params);
}
