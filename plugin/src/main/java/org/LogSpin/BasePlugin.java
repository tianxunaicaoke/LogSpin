package org.LogSpin;

import groovy.lang.Closure;
import reflect.DefaultInstanceCreator;

public class BasePlugin<T extends Spin> implements Plugin<T> {
    InfoContainer infoContainer = new InfoContainer(
            new DefaultInstanceCreator());

    @Override
    public void apply(Spin spin) {
        System.out.println("BasePlugin");
    }

    public void info(Closure closure) {
        System.out.println("info");
        infoContainer.configure(closure,infoContainer);
    }
}
