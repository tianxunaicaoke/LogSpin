package org.LogSpin.core;

import groovy.lang.Closure;


public class ConfigureUtil {

    public static <T> void configureByObject(Closure<?> closure, T target) {
        ConfigureDelegate configureDelegate = new ConfigureDelegate(closure, target);
        Closure<?> withNewOwner = closure.rehydrate(target, configureDelegate, closure.getThisObject());
        withNewOwner.run();
    }

    public static <T> void configureByDelegate(Closure<?> closure, ConfigureDelegate target) {
        Closure<?> withNewOwner = closure.rehydrate(target, target, closure.getThisObject());
        withNewOwner.run();
    }
}
