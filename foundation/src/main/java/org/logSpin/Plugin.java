package org.logSpin;

public interface Plugin<T> {
    void resolveCase(T spin);
    void apply(T spin);
}
