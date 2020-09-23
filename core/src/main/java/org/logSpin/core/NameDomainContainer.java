package org.logSpin.core;

import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class NameDomainContainer<T> extends AbstractDynamicObject {
    private final List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

    public void add(T item) {
        list.add(item);
    }

    public void remove(T item) {
        list.remove(item);
    }

    public void clear() {
        list.clear();
    }

    public abstract T create(String name, Object[] args);

    public void configure(Closure<?> closure, NameDomainContainer<?> container) {
        ConfigureUtil.configureByDelegate(closure,
                new NamedDomainContainerConfigureDelegate(closure, container));
    }
}
