package org.LogSpin.core;

import groovy.lang.GroovyObject;
import groovy.lang.GroovySystem;
import groovy.lang.MetaClass;
import groovy.lang.MetaMethod;
import org.codehaus.groovy.runtime.MetaClassHelper;

public abstract class AbstractDynamicObject implements DynamicObject{
    @Override
    public Object tryInvokeMethod(Object clazz, String name, Object[] params) {
        MetaClass metaClass = getMetaClass(clazz);
        MetaMethod metaMethod = lookupMethod(metaClass, name, convert(params));
        if(metaMethod != null){
            metaMethod.doMethodInvoke(clazz,params);
            return metaClass;
        }
        return null;
    }

    private MetaClass getMetaClass(Object bean) {
        if (bean instanceof GroovyObject) {
            return ((GroovyObject) bean).getMetaClass();
        } else {
            return GroovySystem.getMetaClassRegistry().getMetaClass(bean.getClass());
        }
    }

    protected MetaMethod lookupMethod(MetaClass metaClass, String name, Class[] arguments) {
        return metaClass.pickMethod(name, arguments);
    }

    private Class[] convert(Object[] arguments) {
        if (arguments == null || arguments.length == 0) {
            return MetaClassHelper.EMPTY_CLASS_ARRAY;
        }
        Class[] classes = new Class[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            Object argType = arguments[i];
            if (argType == null) {
                classes[i] = null;
            } else {
                classes[i] = argType.getClass();
            }
        }
        return classes;
    }
}
