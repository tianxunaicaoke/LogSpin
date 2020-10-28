package org.logSpin.script;

import org.logSpin.Exception.NoMethodFoundException;
import org.logSpin.Plugin;
import org.logSpin.Spin;
import org.logSpin.core.AbstractDynamicObject;

public class DefaultScriptDelegate extends AbstractDynamicObject implements ScriptDelegate {
    private Spin spin;

    public void setSpin(Spin spin) {
        this.spin = spin;
    }

    @Override
    public void apply(String pluginId) {
        Plugin<Spin> plugin = spin.getPluginManager().getPluginById(pluginId);
        plugin.apply(spin);
        spin.getPluginContainer()
                .addPlugin(pluginId, plugin);
    }

    @Override
    public Object invokeMethod(String name, Object[] args) {
        for (Plugin<?> plugin : spin.getPluginContainer().getPlugins().values()) {
            Object result = tryInvokeMethod(plugin, name, args);
            if (result != null) {
                return result;
            }
        }
        throw new NoMethodFoundException(name);
    }
}
