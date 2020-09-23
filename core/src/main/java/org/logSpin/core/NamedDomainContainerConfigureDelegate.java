package org.logSpin.core;

import groovy.lang.Closure;

public class NamedDomainContainerConfigureDelegate extends ConfigureDelegate {
    private final NameDomainContainer<?> container;

    public NamedDomainContainerConfigureDelegate(Closure<?> closure, NameDomainContainer<?> delegate) {
        super(closure, delegate);
        container = delegate;
    }

    @Override
    public Object configure(String s, Object[] params) {
        return container.create(s, params);
    }
}
