package org.LogSpin.core;

import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.List;

public abstract class NameDomainContainer<T> extends AbstractDynamicObject {
    List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public abstract T create(String name, Object[] args);

    public NameDomainContainer<T> configure(Closure<?> closure,NameDomainContainer<?> container) {
        ConfigureUtil.configureByDelegate(closure, new NamedDomainContainerConfigureDelegate(closure, container));
        return this;
    }
}
