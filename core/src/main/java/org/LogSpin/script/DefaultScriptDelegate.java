package org.LogSpin.script;

import org.LogSpin.Exception.NoMethodFindException;
import org.LogSpin.Plugin;
import org.LogSpin.Spin;
import org.LogSpin.core.AbstractDynamicObject;

public class DefaultScriptDelegate extends AbstractDynamicObject implements ScriptDelegate {
    Spin spin;

    public void setSpin(Spin spin) {
        this.spin = spin;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void apply(String pluginId) {
        Plugin<Spin> plugin = spin.getPluginManager().getPluginById(pluginId);
        plugin.apply(spin);
        spin.getPluginContainer().addPlugin(plugin);
    }

    @Override
    public Object invokeMethod(String name, Object[] args) {
        for (Plugin<?> plugin : spin.getPluginContainer().getPlugins()) {
            Object result = tryInvokeMethod(plugin, name, args);
            if (result != null) {
                return result;
            }
        }
        throw new NoMethodFindException(name);
    }
}
