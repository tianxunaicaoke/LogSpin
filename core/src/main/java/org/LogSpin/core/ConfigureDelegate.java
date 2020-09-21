package org.LogSpin.core;

import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;

public class ConfigureDelegate extends GroovyObjectSupport {
    Object owner;
    DynamicObject delegate;
    public ConfigureDelegate(Closure<?> closure, AbstractDynamicObject delegate){
        this.owner = closure.getOwner();
        this.delegate = delegate;
    }

    public Object configure(String s, Object[] params) {
        return null;
    }

    @Override
    public Object invokeMethod(String name, Object args) {
        Object[] params = (Object[])args;
        if(delegate.tryInvokeMethod(delegate,name,params) == null){
            configure(name,params);
        }
        return null;
    }
}
