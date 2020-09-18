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

    public abstract T create(String name);

    public NameDomainContainer<T> configure(Closure closure,NameDomainContainer container) {
        ConfigureDelegate containerConfigureDelegate = new NamedDomainContainerConfigureDelegate(closure,container);
        Closure withNewOwner = closure.rehydrate(container, containerConfigureDelegate, closure.getThisObject());
        withNewOwner.call();
        return this;
    }
}
