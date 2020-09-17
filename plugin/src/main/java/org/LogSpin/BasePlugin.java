package org.LogSpin;

import groovy.lang.Closure;

public class BasePlugin<T extends Spin> implements Plugin<T> {
    @Override
    public void apply(Spin spin) {
        System.out.println("BasePlugin");
    }

    public void info(Closure closure) {
     System.out.println("info");
     closure.call();
    }
}
