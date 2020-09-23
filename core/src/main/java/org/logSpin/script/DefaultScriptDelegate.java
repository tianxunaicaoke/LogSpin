package org.logSpin.script;

import org.logSpin.Exception.NoMethodFindException;
import org.logSpin.Plugin;
import org.logSpin.Spin;
import org.logSpin.core.AbstractDynamicObject;

public class DefaultScriptDelegate extends AbstractDynamicObject implements ScriptDelegate {
    private Spin spin;

    public void setSpin(Spin spin) {
        this.spin = spin;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void apply(String pluginId) {
        Plugin<Spin> plugin = (Plugin<Spin>) spin.getPluginManager().getPluginById(pluginId);
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
