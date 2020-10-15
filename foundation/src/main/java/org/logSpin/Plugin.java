package org.logSpin;

public interface Plugin<T> {
    void resolveCase(T t);
    void apply(T t);
}
