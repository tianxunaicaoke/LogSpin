package org.LogSpin.core;

public interface DynamicObject {
    Object tryInvokeMethod(Object clazz,String name, Object[] params);
}
