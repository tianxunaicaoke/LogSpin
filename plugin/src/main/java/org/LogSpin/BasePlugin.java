package org.LogSpin;

import groovy.lang.Closure;
import org.LogSpin.reflect.DefaultInstanceCreator;

public class BasePlugin<T extends Spin> implements Plugin<T> {
    InfoContainer infoContainer = new InfoContainer(
            new DefaultInstanceCreator());

    @Override
    public void apply(Spin spin) {
        System.out.println("BasePlugin");
    }

    @SuppressWarnings("unused")
    public void info(Closure<?> closure) {
        infoContainer.configure(closure,infoContainer);
    }
}
