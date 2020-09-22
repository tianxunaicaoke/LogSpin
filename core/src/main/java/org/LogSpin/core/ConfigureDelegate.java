package org.LogSpin.core;

import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;
import org.LogSpin.DynamicObject;
import org.LogSpin.Exception.NoMethodFindException;

public class ConfigureDelegate extends GroovyObjectSupport {
    DynamicObject owner;
    DynamicObject delegate;

    public ConfigureDelegate(Closure<?> closure, Object delegate) {
        if (delegate instanceof AbstractDynamicObject) {
            this.delegate = (DynamicObject) delegate;
        } else {
            this.delegate = new WrapperDynamicObject(delegate);
        }
        this.owner = new WrapperDynamicObject(closure.getOwner());
    }

    public Object configure(String s, Object[] params) {
        return null;
    }

    @Override
    public Object invokeMethod(String name, Object args) {
        Object[] params = (Object[]) args;
        Object result = delegate.tryInvokeMethod(delegate,name, params);
        if (result == null) {
            result = configure(name, params);
        }
        if (result == null) {
            owner.tryInvokeMethod(owner,name, params);
        }
        if(result == null){
            throw new NoMethodFindException(name);
        }
        return result;
    }
}
