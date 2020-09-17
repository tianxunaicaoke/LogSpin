package org.LogSpin.script;

import groovy.lang.GroovyObject;
import groovy.lang.GroovySystem;
import groovy.lang.MetaClass;
import groovy.lang.MetaMethod;
import org.LogSpin.Plugin;
import org.LogSpin.Spin;
import org.codehaus.groovy.runtime.MetaClassHelper;

public class DefaultScriptDelegate implements ScriptDelegate {
    Spin spin;

    public void setSpin(Spin spin){
        this.spin = spin;
    }

    @Override
    public void apply(String pluginId) {
      Plugin plugin = spin.getPluginManager().getPluginById(pluginId);
      plugin.apply(spin);
      spin.getPluginContainer().addPlugin(plugin);
    }

    @Override
    public Object invokeMethod(String name, Object[] args) {
        for (Plugin plugin: spin.getPluginContainer().getPlugins()) {
            MetaClass metaClass = getMetaClass(plugin);
            MetaMethod metaMethod = lookupMethod(metaClass, name, convert(args));
            if(metaMethod!=null){
                metaMethod.doMethodInvoke(plugin,args);
            }
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
