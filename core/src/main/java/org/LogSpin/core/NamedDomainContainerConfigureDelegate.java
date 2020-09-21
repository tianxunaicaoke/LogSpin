package org.LogSpin.core;

import groovy.lang.Closure;

public class NamedDomainContainerConfigureDelegate extends ConfigureDelegate {
    NameDomainContainer<?> container;
    public NamedDomainContainerConfigureDelegate(Closure<?> closure, NameDomainContainer<?> delegate) {
        super(closure, delegate);
        container = delegate;
    }

    @Override
    public Object configure(String s, Object[] params) {
        Object item = container.create(s);
        if(params[0] instanceof Closure){
            ((Closure<?>) params[0]).run();
        }
        return item;
    }
}
